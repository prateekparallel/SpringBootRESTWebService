package com.web.controller.impl;


import com.web.webservice.manager.WebServiceManager;

import javax.servlet.http.HttpServletRequest;

import com.web.controller.Github;

public class GithubImpl{
	
	
	public Object getGithubList(HttpServletRequest httpRequest) {
		return WebServiceManager.sendGETmsg(httpRequest);
	}

}
