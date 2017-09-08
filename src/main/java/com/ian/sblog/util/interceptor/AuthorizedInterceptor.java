package com.ian.sblog.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ian.sblog.service.impl.SimpleMessage;
import com.ian.sblog.util.messsage.MsgType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

import java.io.PrintWriter;

public class AuthorizedInterceptor implements HandlerInterceptor{

	private static final String[] IGNORE_URI = {"/account/login", "/404.html", "/favicon.ico", "/account/signup"};
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exp)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		boolean flag = false;
		
		String servletPath = request.getServletPath();
		
		for(String uri : IGNORE_URI) {
			if (servletPath.contentEquals(uri)) {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			User user = (User) request.getSession().getAttribute(SBlogConstants.USER_SESSION);
			if (user == null) {
				ObjectMapper objectMapper = new ObjectMapper();
				String msg = objectMapper.writeValueAsString(new SimpleMessage(MsgType.error, null, "请先登录！"));
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.setStatus(403);
//				response.sendError(403, "No authorization to visit this url, please login first.");
				PrintWriter out = response.getWriter(); // 获取print writer要在设置 character encoding之后，否则会有乱码
				out.print(msg);
				out.flush();
			}else {
				flag = true;
			}
		}
		return flag;
	}

}
