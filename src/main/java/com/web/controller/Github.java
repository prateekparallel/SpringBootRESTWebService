package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.webservice.manager.WebServiceManager;

@Controller
@RequestMapping(path = "/v/github")
public class Github {  

	@GetMapping("/Github.json/repositories") 
	@ResponseBody
	public Object getGithubList(HttpServletRequest httpRequest) {
		return WebServiceManager.sendGETmsg(httpRequest);
	}
	
	/*
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/orders")
	public Response registerCar(@Context UriInfo info CarDetailBean carDetailBean,);	
	*/
}