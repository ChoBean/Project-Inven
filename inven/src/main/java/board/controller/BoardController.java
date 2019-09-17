package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.FileUploadService;
import board.util.AuthInfo;
import board.util.BroadcastInfo;

@Controller
@SessionAttributes("boardVO")
public class BoardController {
	
	private BoardService boardService;
	private FileUploadService fileUploadService;
	
	public void setBoardService(BoardService boardService){
		this.boardService = boardService;
	}
	
	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService; 
	}
	
	
	@RequestMapping(value="/list/ucc/{pageNum}")
	public String uccList(Model model, @PathVariable int pageNum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("category", "ucc");
		map.put("start",pageNum * 10 - 10);
		
		model.addAttribute("pageNum", boardService.count("ucc")/10+1);
		model.addAttribute("boardList", boardService.list(map));
		model.addAttribute("category", "ucc");
		model.addAttribute("bestImageReadCount", boardService.bestImageReadCount());
		model.addAttribute("bestVideoReadCount", boardService.bestVideoReadCount());
		
		return "board/uccList";
	}

	@RequestMapping(value= "/list/{category}/{pageNum}")
	public String list(Model model, @PathVariable String category, @PathVariable int pageNum){
		if (category.equals("free")||category.equals("playtip")||category.equals("meeting")
				||category.equals("incident")||category.equals("Q&A")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("category", category);
			map.put("start", pageNum * 10 - 10);
			model.addAttribute("pageNum", boardService.count(category) / 10 + 1);
			model.addAttribute("boardList", boardService.list(map));	
			return "board/list"; 
		}else {
			return "redirect:/listAll/1";
		}
	}
	
	@RequestMapping(value="/listAll/{pageNum}")
	public String listAll(Model model, @PathVariable int pageNum) {
		int start =  pageNum * 10 - 10;
		model.addAttribute("pageNum", boardService.countAll() / 10 + 1);
		model.addAttribute("boardListAll", boardService.listAll(start));
		return "board/listAll";
	}
	
	@RequestMapping(value="/listAllSearch/{pageNum}/{search}")
	public String listAllSearch(Model model, @PathVariable int pageNum, @PathVariable String search) {
		int start =  pageNum * 10 - 10;
		model.addAttribute("pageNum", boardService.countAll() / 10 + 1);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("search", "%" + search + "%");
		model.addAttribute("boardListAll", boardService.listAllSearch(map));
		return "board/listAll";
	}
	
	@RequestMapping(value="/read/{num0}")
	public String read(Model model, @PathVariable int num0){
		BoardVO vo = boardService.read(num0);
        model.addAttribute("boardVO", vo);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("num1", vo.getNum1());
        map.put("category", vo.getCategory());
        model.addAttribute("boardListUnder", boardService.listUnder(map));
        return "board/read";
	}
	
	@RequestMapping(value="/write/{category}", method=RequestMethod.GET)
	public String write(Model model, @PathVariable String category, HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
		
		BoardVO vo = new BoardVO();
		vo.setWriter((String) session.getAttribute("writer"));
		model.addAttribute("boardVO", vo);
		model.addAttribute("category", category);
		return "board/write";
	}
	//새 글 등록을 위한 요청을 처리 
	@RequestMapping(value="/write/{category}", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, @PathVariable String category, String subTitle,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "board/write";
		}
		boardVO.setCategory(category);
		if (!subTitle.equals("")) {
			boardVO.setTitle("[" + subTitle + "] " + boardVO.getTitle());
		}
		String url = fileUploadService.restore(file);
		String filepath = "";
		String filename = "";
		if (!url.equals("")) {
			filepath = url.substring(0, url.lastIndexOf("/") + 1);
			filename = url.substring(url.lastIndexOf("/") + 1);
		}
		
		boardVO.setFilepath(filepath);
		boardVO.setFilename(filename);
		boardService.write(boardVO);
		return "redirect:/list/" + boardVO.getCategory() + "/1";
	}
	
	@RequestMapping(value="/writeUnder/{num0}", method=RequestMethod.POST)
	public String writeUnder(@Valid BoardVO boardVO, BindingResult bindingResult, HttpSession session,
			@PathVariable int num0, String content) {
		if (bindingResult.hasErrors()) {
			return "board/writeUnder";
		}
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
		
		BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        
		BoardVO vo2 = new BoardVO();
		vo2.setWriter(writer);
		vo2.setCategory(vo.getCategory());
		vo2.setTitle(vo.getTitle());
		vo2.setNum1(vo.getNum1());
		vo2.setContent(content);
		
		boardService.writeUnder(vo2);
		return "redirect:/read/" + num0;
	}
	
	//글 수정
	@RequestMapping(value="/edit/{num0}", method=RequestMethod.GET)
	public String edit(Model model, @PathVariable int num0, HttpSession session){
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
        model.addAttribute("boardVO", vo);
        model.addAttribute("category", vo.getCategory());
        return "board/edit";
	}
	        
	@RequestMapping(value="/edit/{num0}", method=RequestMethod.POST)
	public String edit(@Valid BoardVO boardVO, @PathVariable int num0, String subTitle,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()){
			return "board/edit";
		}
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
		String url = fileUploadService.restore(file);
		String filepath = "";
		String filename = "";
		if (!subTitle.equals("")) {
			boardVO.setTitle("[" + subTitle + "] " + boardVO.getTitle());
		}
		if (!url.equals("")) {
			filepath = url.substring(0, url.lastIndexOf("/") + 1);
			filename = url.substring(url.lastIndexOf("/") + 1);
		}
		
		boardVO.setFilepath(filepath);
		boardVO.setFilename(filename);
		
		boardService.edit(boardVO);
		return "redirect:/list/" + boardVO.getCategory() + "/1";
	}
	
	//글 삭제 요청을 처리할 메서드
	@RequestMapping(value="/delete/{num0}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable int num0, HttpSession session){
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
        model.addAttribute("boardVO", vo);
		return "board/delete";
	}
	
	@RequestMapping(value="/delete/{num0}", method=RequestMethod.POST)
	public String delete(@PathVariable int num0, HttpSession session){
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
		boardService.delete(vo.getNum1());
		// 삭제 결과 창으로 옮기기
		return "redirect:/list/" + vo.getCategory() + "/1";
	}
	
	@RequestMapping(value="/editUnder/{num0}", method=RequestMethod.GET)
	public String editUnder(Model model, @PathVariable int num0, HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
        
        model.addAttribute("boardVO", vo);
        return "board/editUnder";
	}
	
	@RequestMapping(value="/editUnder/{num0}", method=RequestMethod.POST)
	public String editUnder(@Valid BoardVO boardVO, @PathVariable int num0, HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        String writer = (String) session.getAttribute("writer");
        if (!boardVO.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
        boardService.editUnder(boardVO);
        // 성공창으로 옮기기
        return "redirect:/list/" + boardVO.getCategory() + "/1";
	}
	
	@RequestMapping(value="/deleteUnder/{num0}", method=RequestMethod.GET)
	public String deleteUnder(Model model, @PathVariable int num0, HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
        
        model.addAttribute("boardVO", vo);
        return "board/deleteUnder";
	}
	
	@RequestMapping(value="/deleteUnder/{num0}", method=RequestMethod.POST)
	public String deleteUnder(@PathVariable int num0, HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			return "redirect:/error/login";
		}
        BoardVO vo = boardService.read(num0);
        String writer = (String) session.getAttribute("writer");
        if (!vo.getWriter().equals(writer)) {
        	return "redirect:/error/notyou";
        }
        boardService.deleteUnder(vo);
        // 성공창으로 옮기기
        return "redirect:/list/" + vo.getCategory() + "/1";
	}
	
	@RequestMapping(value="/download/{num0}")
	public void down(@PathVariable int num0, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = boardService.download(num0);
		File file = new File(url);
		response.setContentType(request.getContentType());
        response.setContentLength((int)file.length());
        String userAgent = request.getHeader("User-Agent");
        boolean ie = userAgent.indexOf("MSIE") > -1;
        String fileName = null;
        if(ie) {
            fileName = URLEncoder.encode(file.getName(), "utf-8");
        } else {
            fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
 
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch(IOException ioe) {}
            }
        }
        out.flush();
 
//        /* 다운로드 후  다시 변경된 이름으로 변경  */
//        if(request.getParameter("stored_file_name") != null){
//            File original_file= new File(file.getPath()); //원본 경로+파일
//            String file_path  = original_file.toString().replace(file.getName(),""); //path 추출
//            File stored_file  = new File(file_path+request.getParameter("stored_file_name"));//변경 파일명
//            original_file.renameTo(stored_file);//이름 변경
//        }
	}
	
	@RequestMapping(value="/error/{errorMessage}")
	public String errorPage(Model model, @PathVariable String errorMessage) {
		model.addAttribute("errorMessage", errorMessage);
		return "board/error";
	}

	@RequestMapping(value="/deleteAdmin/{num0}")
	public String deleteAdmin(@PathVariable int num0, HttpSession session, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer = response.getWriter();
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			writer.println("<script> alert('잘못된 접근입니다.'); location.href='/login'</script> ");
			writer.flush();
		}
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		int grade = authInfo.getGrade();
		
		if (grade < 10) {
			writer.println("<script> alert('권한이 없습니다.'); location.href='/login'</script> ");
			writer.flush();
		}
		
		BoardVO vo = boardService.read(num0);
		
		boardService.deleteAdmin(vo.getNum1());
		return "redirect:/list/" + vo.getCategory() + "/1";
	}
	
	@RequestMapping(value="/deleteUnderAdmin/{num0}")
	public String deleteUnderAdmin(@PathVariable int num0, HttpSession session, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer = response.getWriter();
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			writer.println("<script> alert('잘못된 접근입니다.'); location.href='/login'</script> ");
			writer.flush();
		}
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		int grade = authInfo.getGrade();
		
		if (grade < 10) {
			writer.println("<script> alert('권한이 없습니다.'); location.href='/login'</script> ");
			writer.flush();
		}
		
		BoardVO vo = boardService.read(num0);
		
		boardService.deleteUnderAdmin(vo);
		return "redirect:/list/" + vo.getCategory() + "/1";
	}
	
	@RequestMapping(value="/readUnder/{num1}")
	public String readUnder(@PathVariable int num1) {
		int num0 = boardService.readUnder(num1);
		return "redirect:/read/" + num0;
	}
	
	@RequestMapping(value="/broadcastInfo/{radioVal}")
	public String broadcast(Model model, @PathVariable String radioVal) {
		BroadcastInfo bcif = new BroadcastInfo();
		model.addAttribute("twitchStreamer", bcif.getTwitchStreamer());
		model.addAttribute("twitchId", bcif.getTwitchId());
		model.addAttribute("twitchThumbNail", bcif.getTwitchThumbNail());
		model.addAttribute("youtubeStreamer", bcif.getYoutubeStreamer());
		model.addAttribute("youtubeId", bcif.getYoutubeId());
		model.addAttribute("twitchListSize", bcif.getTwitchStreamer().size());
		model.addAttribute("youtubeListSize", bcif.getYoutubeStreamer().size());
		return "/board/broadcastInfo";
	}
}

