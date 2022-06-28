package dev.cho.service;

import java.util.List;

import dev.cho.model.RequestTicket;
import dev.cho.repositories.RequestDAO;

public class RequestService {
	private static RequestDAO rd;
	
	public RequestService(RequestDAO rd) {
		this.rd = rd;
	}
	
	public RequestTicket createTicket(RequestTicket r, int id) {
		
		return rd.createTicket(r, id);
	}
	
	public List<RequestTicket> getAllRequests(int userID){
		
		return rd.getAllRequests(userID);
	}
	
	public RequestTicket getSingleRequest(int userId, int requestId) {
		
		return rd.getSingleRequest(userId, requestId);
	}
}
