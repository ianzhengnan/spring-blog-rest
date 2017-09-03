package com.ian.sblog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ian.sblog.domain.Message;
import com.ian.sblog.util.CookieHandler;
import com.ian.sblog.util.messsage.MsgType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

@RestController
@RequestMapping("/account")
public class PassportController extends BaseController{

	@RequestMapping(value = "/login", method = RequestMethod.POST) // 只有一个参数时候，可以简写省去value = ""
	public Message handleLogin(@RequestParam(value = "username", required = false) String username,
							   @RequestParam(value = "password", required = false) String password,
							   HttpServletResponse response) {
		
		log.debug("PassportController >> login");
//		Message message = MessageFactory.getMessage();
		Message message = new Message();

		User user = us.logon(username, password);
		if (user != null) {
			CookieHandler.addCookie(response, "username", user.getUsername());
			message.setType(MsgType.success);
			message.setMsg("登录成功！");
			return message;
		}else {
			// 未来用message class替换
            message.setType(MsgType.error);
			message.setMsg("用户名或密码错误！");
			return message;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Message logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = CookieHandler.getCookie(request, SBlogConstants.USER);
		if (cookie != null){
			CookieHandler.delCookie(request, response, SBlogConstants.USER);
		}
		return new Message(MsgType.success, null, "logout成功");
	}

	@RequestMapping(value = "/signup")
	public ModelAndView signup(String show, ModelAndView mv, @ModelAttribute User user, HttpSession httpSession) {

		if (!us.checkUsername(user)) {
			us.register(user);
			httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
			mv.setViewName("redirect:../main");
		}else {
			mv.addObject("message", "用户名已经存在");
			mv.setViewName("user/signup");
		}

		return mv;
	}
	
}
