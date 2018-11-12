package com.baizhi.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptors implements HandlerInterceptor {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object method) throws Exception {
		Object obj = request.getSession().getAttribute("admin");
		if(obj==null){
			response.sendRedirect(request.getContextPath()+"/back/login.jsp");
			return false;
		}
		return true;
	}
	


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object method, ModelAndView mv) throws Exception {
		// TODO Auto-generated method stub
		mv.addObject("date", new Date());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object method, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("当前异常信息为: "+exception.getMessage());
	}

			
}
