package board.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.exception.IdPasswordNotMatchingException;
import board.service.UserService;
import board.util.AuthInfo;
import board.util.LoginCommand;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView loginForm(HttpSession session,LoginCommand loginCommand,
            @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) throws Exception {
		boolean flag = (session.getAttribute("loginChk") == null) ? false : true;
		if(flag) {
			ModelAndView mv = new ModelAndView("redirect:/errors/alreaylogin");
			return mv;
		}
			
		if(rememberCookie != null) {
			loginCommand.setId(rememberCookie.getValue());
			loginCommand.setRememberId(true);
		}
		
		ModelAndView mv = new ModelAndView("register/loginForm");
		return mv;
	}
	
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid LoginCommand loginCommand, BindingResult bindingResult,
             HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {
		boolean loginChk = false;
		if(bindingResult.hasErrors()) {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('일치하는 회원이 없습니다.'); location.href='/login';</script>");
			writer.flush();
			ModelAndView mv = new ModelAndView("register/loginForm");
			return mv;
		}
		
		try {
			AuthInfo authInfo = userService.loginAuth(loginCommand);
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60 * 24);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			session.setAttribute("writer", authInfo.getName());
			userService.updateVisit(authInfo.getName());
		}catch(IdPasswordNotMatchingException e) {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter writera = response.getWriter();
			writera.println("<script> alert('일치하는 회원이 없습니다.'); location.href='/login'; </script> ");
			writera.flush();
			ModelAndView mv = new ModelAndView("/register/loginForm");
			return mv;
		}
		
		loginChk = true;
		session.setAttribute("loginChk", loginChk);
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	

}
