package board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.service.CharacterService;

@Controller
public class CharacterController {
	
	private CharacterService characterService;
	
	public void setCharacterService(CharacterService characterService){
		this.characterService = characterService;
	}
	
	@RequestMapping(value="/characterListAll/{pageNum}")
	public String characterListAll(Model model, @PathVariable int pageNum) {
		int start = pageNum * 10 - 10;
		int end = 10;
		HashMap <String, Object> map = new HashMap <String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("characterListAll", characterService.listAll(map));
		return "board/characterListAll";
	}
	
	@RequestMapping(value="/characterRead/{name}")
	public String characterRead(Model model, @PathVariable String name) {
		model.addAttribute("characterVO", characterService.read(name));
		return "board/characterRead";
	}
	
	@RequestMapping(value="/characterSelectByName", method=RequestMethod.POST)
	public String characterSelectByName(Model model, HttpServletRequest req) {
		String keyWord = req.getParameter("keyWord");
		String temp = "%" + keyWord + "%";
		keyWord=temp;
		model.addAttribute("selectByName", characterService.selectByName(keyWord));
		return "board/characterList";
	}
	
	@RequestMapping(value="/characterSelectByScenario/{scenario}", method=RequestMethod.GET)
	public String characterSelectByScenario(Model model, @PathVariable String scenario) {
		model.addAttribute("selectByScenario", characterService.selectByScenario(scenario));
		return "board/characterList";
	}
	
	
}
