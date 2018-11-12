package com.baizhi.exceptionresolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionresolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object method, Exception exception) {
			ModelAndView modelAndView = new ModelAndView();
			//System.out.println(exception.getMessage());
			modelAndView.setViewName("index");
			modelAndView.addObject("message", exception.getMessage());
			return modelAndView;
	}

}
