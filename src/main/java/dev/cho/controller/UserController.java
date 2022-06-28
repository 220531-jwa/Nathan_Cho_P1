package dev.cho.controller;

import dev.cho.model.User;
import dev.cho.service.UserService;
import io.javalin.http.Context;

public class UserController {
	private static UserService us;
	
	public UserController(UserService us) {
		this.us = us;
	}
	
	public void getUserById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		User u = null;
		try {
			u = us.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(u != null) {
			ctx.status(200);
			ctx.json(u);
			}
			else {
				ctx.status(404);
				ctx.result("User Not Found");
			}
	}
	
	public void login(Context ctx) {
		
		User u = ctx.bodyAsClass(User.class);
		
		if(us.checkUandP(u.getUsername(), u.getPassword()) != null) {
			User loginUser = us.checkUandP(u.getUsername(), u.getPassword());
			ctx.status(200);
			ctx.json(loginUser);
		}
		else {
			ctx.status(404);
		}
		
	}
	
	public void createUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		
		User created = us.createUser(u);
		ctx.status(200);
		ctx.json(created);
	}
	
}
