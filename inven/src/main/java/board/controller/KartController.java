package board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board.model.KartVO;
import board.service.KartService;

@Controller
public class KartController {
	
	private KartService kartService;
	
	public void setKartService(KartService kartService) {
		this.kartService = kartService;
	}
	
	@RequestMapping(value="/kartInfo/{pageNum}")
	public String getAll(Model model, @PathVariable int pageNum) {
		model.addAttribute("kartList", kartService.getAll(pageNum * 10 - 10));
		int temp = 0;
		if (kartService.getAllCount()%10 == 0) {
			temp = kartService.getAllCount() / 10;
		}else {
			temp = kartService.getAllCount() / 10 + 1;
		}
		model.addAttribute("pageNum", temp);
		model.addAttribute("pageName", "/kartInfo/");
		return "/board/kartInfo";
	}
	
	@RequestMapping(value="/kartInfoBySearch/{search}/{pageNum}")
	public String getBySearch(Model model, @PathVariable String search, @PathVariable int pageNum) {
		HashMap <String, Object> map = new HashMap <String, Object>();
		map.put("search", "%" + search + "%");
		map.put("start", pageNum * 10 - 10);
		List<KartVO> list = kartService.getBySearch(map);
		model.addAttribute("kartList", list);
		model.addAttribute("pageNum", list.size() / 10 + 1);
		model.addAttribute("pageName", "/kartInfoBySearch/" + search);
		return "/board/kartInfo";
	}
	
	@RequestMapping(value="/kartInfoByEngine/{engine}/{pageNum}")
	public String getByEngine(Model model, @PathVariable String engine, @PathVariable int pageNum) {
		HashMap <String, Object> map = new HashMap <String, Object>();
		map.put("engine", engine);
		map.put("start", pageNum * 10 - 10);
		List<KartVO> list = kartService.getByEngine(map);
		model.addAttribute("kartList", list);
		model.addAttribute("pageNum", list.size() / 10 + 1);
		model.addAttribute("pageName", "/kartInfoByEngine/" + engine);
		return "/board/kartInfo";
	}
	
	@RequestMapping(value="/kartInfoByType/{type}/{pageNum}")
	public String getByType(Model model, @PathVariable String type, @PathVariable int pageNum) {
		HashMap <String, Object> map = new HashMap <String, Object>();
		map.put("type", type);
		map.put("start", pageNum * 10 - 10);
		List<KartVO> list = kartService.getByType(map);
		model.addAttribute("kartList", list);
		model.addAttribute("pageNum", list.size() / 10 + 1);
		model.addAttribute("pageName", "/kartInfoByType/" + type);
		return "/board/kartInfo";
	}
	
	@RequestMapping(value="/kartInfoByRate/{rate}/{pageNum}")
	public String getByRate(Model model, @PathVariable String rate, @PathVariable int pageNum) {
		HashMap <String, Object> map = new HashMap <String, Object>();
		map.put("rate", rate);
		map.put("start", pageNum * 10 - 10);
		List<KartVO> list = kartService.getByRate(map);
		model.addAttribute("kartList", list);
		model.addAttribute("pageNum", list.size() / 10 + 1);
		model.addAttribute("pageName", "/kartInfoByRate/" + rate);
		return "/board/kartInfo";
	}
}
