package com.ian.sblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

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
				request.setAttribute("message", "请先登录再访问网站！");
				//request.getRequestDispatcher(SBlogConstants.LOGIN).forward(request, response); // url不能做出相应的改变
				response.sendRedirect(SBlogConstants.LOGIN);
			}else {
				flag = true;
			}
		}
		return flag;
	}

}
