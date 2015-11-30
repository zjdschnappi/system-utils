package com.system.utils.csrf;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Referer extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8548040856652712527L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext(); 
		HttpServletRequest req= (HttpServletRequest)ctx.get(StrutsStatics.HTTP_REQUEST);
		String urlHost = req.getRemoteHost();
		String referer = req.getHeader("Referer"); 
		return null;
	}

}
