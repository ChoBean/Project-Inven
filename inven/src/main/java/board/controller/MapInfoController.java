package board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardVO;
import board.model.MapInfoVO;
import board.service.MapInfoService;

@Controller
public class MapInfoController {
	
	private MapInfoService mapInfoService;

	public void setMapInfoService(MapInfoService mapInfoService) {
		this.mapInfoService = mapInfoService;
	}



	@RequestMapping(value="/mapInfo/{pageNum}")
	public ModelAndView mapInfoGo(@PathVariable int pageNum){
		ModelAndView mv = new ModelAndView("/board/mapInfo");
		int start = pageNum * 10 - 10;
		mv.addObject("pageNum", mapInfoService.listAllCount() / 10 + 1);
		mv.addObject("mapInfoList",mapInfoService.listAll(start));
		return mv;
	}
	
	@RequestMapping(value="/mapInfoContent/{mapnum}")
	public ModelAndView read(@PathVariable int mapnum){
		MapInfoVO vo = mapInfoService.read(mapnum);
		ModelAndView mv = new ModelAndView("/board/mapInfoContent");
        mv.addObject("mapInfoVO", vo);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("num1", vo.getMapnum());
        return mv;
	}
	
	@RequestMapping(value={"/mapInfoFilter/{path:[a-z-]+}"}, method=RequestMethod.GET) 
	public ModelAndView getCenter(@PathVariable String path) throws Exception {
		ModelAndView mv = new ModelAndView("/board/mapInfoFilter");
		mv.addObject("mapInfoFilter", mapInfoService.listFilter(path));
		return mv;
	} 
	
	
}
