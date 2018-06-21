package com.sasori.web.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

	public class HandshakeInterceptor implements HandlerInterceptor {

	    @Override
	    public void afterCompletion(HttpServletRequest httpRequest,
	            HttpServletResponse httpResponse, Object arg2, Exception arg3)
	            throws Exception {
	         
	    }

	    @Override
	    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
	            Object arg2, ModelAndView arg3) throws Exception {
	        

	    }

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	            Object object) throws Exception {
	        /*HttpServletRequest httpRequest = (HttpServletRequest) request;  
	         HttpServletResponse httpResponse = (HttpServletResponse) response;*/
	        String urlString = request.getRequestURI();
	            
	        ///olForum/forumList.html模拟登录页
	        if(urlString.endsWith("forumList.html")){
	            return true;
	        }
	        //请求的路径
	        String contextPath=request.getContextPath();
	       
	        /*httpRequest.getRequestDispatcher("/olForum/forumList").forward(httpRequest, httpResponse);*/
	        /*response.sendRedirect(contextPath+"/olForum/forumList.html");*/
	        response.sendRedirect(contextPath + "/olForum/forumList.html?login=aaa");  
	        return false;
	        /*httpResponse.sendRedirect(httpRequest.getContextPath()+"/olForum/forumList.html");
	        return;*/
	        

	    }

}