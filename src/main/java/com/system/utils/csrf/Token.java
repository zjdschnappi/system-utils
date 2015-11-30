package com.system.utils.csrf;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Token extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext(); 
		HttpServletRequest req= (HttpServletRequest)ctx.get(StrutsStatics.HTTP_REQUEST);
		String token = req.getHeader("crsfToken");
		
		return null;
	}

}
