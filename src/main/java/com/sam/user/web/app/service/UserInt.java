package com.sam.user.web.app.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sam.user.web.app.data.User;

/**
 * @author Samuel Tanor-Gyedu
 * 
 */
@Path("/userAccountService/")
@Consumes("application/json")
@Produces("application/json")
public interface UserInt {
	@GET
	@Path("/echo/{echo}/")
	public String echo(@PathParam("echo") String echo);

	@GET
	@Path("/getUser/{id}")
	public User getUser(@PathParam("id") Long userId);

	@POST
	@Path("/login/")
	public User login(User user);

	@POST
	@Path("/register/")
	public Long register(User user);

}
