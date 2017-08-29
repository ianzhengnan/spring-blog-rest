package com.ian.sblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

@Controller
@RequestMapping("/account")
public class PassportController extends BaseController{

	@RequestMapping(value = "/login", method = RequestMethod.POST) // 只有一个参数时候，可以简写省去value = ""
	public ModelAndView handleLogin(@RequestParam(value = "username", required = false) String username, 
							@RequestParam(value = "password", required = false) String password,
							HttpSession httpSession,
							ModelAndView mv) {
		
		log.debug("PassportController >> login");
		
		User user = us.logon(username, password);
		if (user != null) {
			httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
			mv.setViewName("redirect:../main");
		}else {
			// 未来用message class替换
			mv.addObject("message", "登录名和密码错误，请重新登录！");
			mv.setViewName("login"); // 这里的loginPage是loginPage.jsp的名字
		}
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login"; //jsp文件名
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		if(httpSession.getAttribute(SBlogConstants.USER_SESSION) != null) {
			httpSession.removeAttribute(SBlogConstants.USER_SESSION);			
		}
		return "redirect:" + SBlogConstants.LOGIN;
	}
	
	@RequestMapping(value = "/signup")
	public ModelAndView signup(String show, ModelAndView mv, @ModelAttribute User user, HttpSession httpSession) {
		
		if (show.equals("1")) {
			mv.setViewName("user/signup");
		}else {
			if (!us.checkUsername(user)) {
				us.register(user);
				httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
				mv.setViewName("redirect:../main");
			}else {
				mv.addObject("message", "用户名已经存在");
				mv.setViewName("user/signup");
			}
		}
		return mv;
	}
	
}
