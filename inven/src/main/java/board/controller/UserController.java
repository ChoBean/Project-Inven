package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import board.exception.AlreadyExistingEmailException;
import board.exception.AlreadyExistingIdException;
import board.exception.AlreadyExistingNameException;
import board.exception.PasswordNotMatchingException;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.UserService;
import board.util.AuthInfo;
import board.util.DeleteRequest;
import board.util.DeleteRequestValidator;
import board.util.ModifyRequest;
import board.util.ModifyRequestValidator;
import board.util.RegisterRequest;
import board.util.RegisterRequestValidator;

@Controller

public class UserController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main(HttpSession session,Model model) {
		HashMap<String, Object> uccMap = new HashMap<String, Object>();
		if(boardService.bestVideoReadCount().size() >= 1) {
			BoardVO bestVideo = (BoardVO)boardService.bestVideoReadCount().get(0);
			model.addAttribute("bestVideo", bestVideo);
		}
		if(boardService.bestImageReadCount().size() >= 1) {
			BoardVO bestImage = (BoardVO)boardService.bestImageReadCount().get(0);
			model.addAttribute("bestImage", bestImage);
		}
		uccMap.put("category", "ucc");
		uccMap.put("start",0);
		HashMap<String, Object> freeMap = new HashMap<String, Object>();
		freeMap.put("category", "free");
		freeMap.put("start", 0);
		HashMap<String, Object> tipMap = new HashMap<String, Object>();	
		
		if(boardService.bestPlaytip().size() >= 1) {
			BoardVO bestPlaytip1 = (BoardVO)boardService.bestPlaytip().get(0);
			model.addAttribute("bestPlaytip1",bestPlaytip1);
		}
		if(boardService.bestPlaytip().size() >=2) {
			BoardVO bestPlaytip2 = (BoardVO)boardService.bestPlaytip().get(1);
			model.addAttribute("bestPlaytip2",bestPlaytip2);
		}
		tipMap.put("category", "playtip");
		tipMap.put("start", 0);
		HashMap<String, Object>  meetingMap = new HashMap<String, Object>();
		meetingMap.put("category", "meeting");
		meetingMap.put("start",0);
		model.addAttribute("uccList", boardService.list(uccMap));
		model.addAttribute("freeList", boardService.list(freeMap));
		model.addAttribute("tipList", boardService.list(tipMap));
		model.addAttribute("meetingList",boardService.list(meetingMap));
		
		return "register/index";
	}
	
	@RequestMapping(value="/errors/login")
	public void errorPageLogin(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer;
		writer = response.getWriter();
		writer.println("<script> alert('로그인이 필요 합니다.'); location.href='/login'</script> ");
		writer.flush();
	}
	@RequestMapping(value="/errors/alreaylogin")
	public void errorPageAlreadyLogin(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer;
		writer = response.getWriter();
		writer.println("<script> alert('이미 로그인 중입니다.'); location.href='/'</script> ");
		writer.flush();
	}
	
	@RequestMapping("/register/step1")
	public String step1(HttpSession session) throws Exception{
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(flag) {
			return "redirect:/errors/alreaylogin";
		}
		return "/register/step1";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public void step2(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script> alert('잘못된 접근입니다.'); location.href='/'</script> ");
		writer.flush();
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public ModelAndView step2(@RequestParam(value="agree", defaultValue="false") Boolean agree) throws Exception{
        	
		
		if(!agree || agree == null) {
			ModelAndView mv = new ModelAndView("/register/step1");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/register/step2");
		mv.addObject("registerRequest", new RegisterRequest());
		return mv;
	}
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/register/step3", method=RequestMethod.GET)
	public void step3(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script> alert('잘못된 접근입니다.'); location.href='/'</script> ");
		writer.flush();
	}
	
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public ModelAndView step3(RegisterRequest regReq, Errors errors) throws Exception{
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("/register/step2");
			return mv;
		}
		try {
			userService.register(regReq);
		}catch(AlreadyExistingEmailException e) {
			errors.rejectValue("email", "duplicate", "이미 가입된 이메일 입니다.");
			ModelAndView mv = new ModelAndView("/register/step2");
			return mv;
		}catch(AlreadyExistingIdException e) {
			errors.rejectValue("id", "duplicate", "이미 가입된 아이디 입니다.");
			ModelAndView mv = new ModelAndView("/register/step2");
			return mv;
		}catch(AlreadyExistingNameException e) {
			errors.rejectValue("name", "duplicate", "이미 가입된 닉네임 입니다.");
			ModelAndView mv = new ModelAndView("/register/step2");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/register/step3");
		return mv;
	}
	
	//회원 수정
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public ModelAndView updateInfoGo(HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			ModelAndView mv = new ModelAndView("redirect:/errors/login");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/register/modifyForm");
		mv.addObject("modifyRequest", new ModifyRequest());
		return mv;
	}
	
	@RequestMapping(value="/modifySuc",method=RequestMethod.POST)
	public ModelAndView updateInfo(ModifyRequest modReq, Errors errors, String id, HttpSession session) throws Exception{
		new ModifyRequestValidator().validate(modReq, errors);
		if(errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("/register/modifyForm");
			return mv;
		}
		try {
			userService.update(modReq, id);

		}catch(AlreadyExistingEmailException e) {
			errors.rejectValue("email", "duplicate","이미 가입된 이메일 입니다.");
			ModelAndView mv = new ModelAndView("/register/modifyForm");
			return mv;
		}catch(PasswordNotMatchingException e) {
			errors.rejectValue("existPw", "NotMatching","기존 비밀번호가 틀립니다.");
			ModelAndView mv = new ModelAndView("/register/modifyForm");
			return mv;
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String writer = authInfo.getName();
		map.put("writer", writer);
		map.put("writer2", modReq.getName());
		boardService.editWriter(map);
		session.setAttribute("writer", modReq.getName());
		ModelAndView mv = new ModelAndView("/register/modifySuc");
		return mv;
	
	}

	//회원 탈퇴
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteInfoGo(HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			ModelAndView mv = new ModelAndView("redirect:/errors/login");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/register/deleteForm");
		mv.addObject("deleteRequest", new DeleteRequest());
		return mv;
	}
	
	@RequestMapping(value="/deleteSuc",method=RequestMethod.POST)
	public ModelAndView deleteInfo(DeleteRequest delReq, Errors errors, String id) throws Exception{
		new DeleteRequestValidator().validate(delReq, errors);
		
		try {
			userService.delete(delReq, id);
	
		}catch(PasswordNotMatchingException e) {
			errors.rejectValue("existPw", "NotMatching","기존 비밀번호가 틀립니다.");
			ModelAndView mv = new ModelAndView("/register/deleteForm");
			return mv;
		}
		ModelAndView mv = new ModelAndView("/register/deleteSuc");
		return mv;
	
	}
	
		
	//회원 상세 보기
	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
	public ModelAndView userInfoGo(HttpSession session) {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(!flag) {
			ModelAndView mv = new ModelAndView("redirect:/errors/login");
			return mv;
		}
		
		int listcount = 0;
		int listundercount = 0;
		int visitcount = 0;
		List<BoardVO> list = new ArrayList<BoardVO>();
		List<BoardVO> listUnder = new ArrayList<BoardVO>();
		String name = (String)session.getAttribute("writer");
		try {
			listcount = boardService.getListCount(name);
			listundercount = boardService.getListUnderCount(name);
			list = boardService.getList(name);
			listUnder = boardService.getListUnder(name);
			visitcount = userService.getVisit(name);
		} catch (Exception e) {
			
		}
		
		ModelAndView mv = new ModelAndView("/register/userInfo");
		mv.addObject("visitcount", visitcount);
		mv.addObject("listcount", listcount);
		mv.addObject("listundercount", listundercount);
		mv.addObject("list",list);
		mv.addObject("listUnder",listUnder);
		return mv;
	}
	//회원 상세 보기
		@RequestMapping(value="/userInfou",method=RequestMethod.GET)
		public ModelAndView userInfouGo(HttpSession session) {
			boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
			if(!flag) {
				ModelAndView mv = new ModelAndView("redirect:/errors/login");
				return mv;
			}
			int listcount = 0;
			int listundercount = 0;
			int visitcount = 0;
			List<BoardVO> listUnder = new ArrayList<BoardVO>();
			String name = (String)session.getAttribute("writer");
			
			try {
				listUnder = boardService.getListUnder(name);
				listcount = boardService.getListCount(name);
				listundercount = boardService.getListUnderCount(name);
				visitcount = userService.getVisit(name);
			} catch (Exception e) {
				
			}
			
			ModelAndView mv = new ModelAndView("/register/userInfou");
			mv.addObject("visitcount", visitcount);
			mv.addObject("listUnder",listUnder);
			mv.addObject("listcount", listcount);
			mv.addObject("listundercount", listundercount);
			return mv;
		}
		
		@RequestMapping(value="/trackview",method=RequestMethod.GET)
		public ModelAndView mapViewGo() {
			ModelAndView mv = new ModelAndView("/register/mapView");
			return mv;
		}	
}
