package dev.cho.controller;

import java.util.ArrayList;
import java.util.List;

import dev.cho.model.RequestTicket;
import dev.cho.service.RequestService;
import io.javalin.http.Context;

public class RequestTicketController {
	private static RequestService rs;
	
	public RequestTicketController(RequestService rs) {
		this.rs = rs;
	}
	
	public void createRequest(Context ctx) {
		RequestTicket r = ctx.bodyAsClass(RequestTicket.class);
		int id = Integer.parseInt(ctx.pathParam("id"));
		RequestTicket createdR = rs.createTicket(r, id);
		ctx.status(200);
		ctx.json(createdR);
	}
	
	public void getAllRequests(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("userID"));
		
		List<RequestTicket> requests = new ArrayList<>();
		
		requests = rs.getAllRequests(userId);
		
		if(requests != null) {
			ctx.status(200);
			ctx.json(requests);
		}
		else {
			ctx.status(404);
		}
		
	}
	
	public void getSingleRequest(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("userID"));
		int requestId = Integer.parseInt(ctx.pathParam("requestID"));
		
		RequestTicket req = rs.getSingleRequest(userId, requestId);
		
		if(req != null) {
			ctx.status(200);
			ctx.json(req);
		}
		else {
			ctx.status(404);
		}
	}
	
	public void getAllEmpRequests(Context ctx) {
		
		List <RequestTicket> requests = new ArrayList<>();
		
		requests = rs.getAllEmpRequests();
		
		if(requests != null) {
			ctx.status(200);
			ctx.json(requests);
		}
		
	}
	
	public void getReqById(Context ctx) {
		int requestId = Integer.parseInt(ctx.pathParam("reqId"));
		
		RequestTicket req = rs.getReqById(requestId);
		
		if(req != null) {
			ctx.status(200);
			ctx.json(req);
		}
		else {
			ctx.status(404);
		}
		
	}
	
	public void statusUpdate(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.pathParam("reqId"));
		String newStatus = ctx.body();
		
		RequestTicket updated = rs.statusUpdate(requestId, newStatus);
		
		ctx.json(updated);
	}
}
