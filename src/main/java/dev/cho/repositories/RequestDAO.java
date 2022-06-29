package dev.cho.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.cho.model.RequestTicket;
import dev.cho.utils.ConnectionUtil;

public class RequestDAO {
	public enum gradetype{
		pass,
		fail,
		presentation,
		pending;
	}
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public RequestTicket createTicket(RequestTicket r, int id) {
		String sql = "insert into reimbursementapp.requests values "
				+ "(default,'open',?,?,?,?,?,?,?,?,?) returning *";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getSubject());
			ps.setString(2, r.getDescription());
			ps.setDate(3, (Date) r.getEventDate());
			ps.setString(4, r.getLocation());
			ps.setDouble(5, r.getCost());
			ps.setString(6, r.getEventType());
			
			//switch statement to place enums inside of sql statement
			switch(r.getGrade()) {
			case "pass":
				ps.setObject(7, gradetype.pass.toString(), Types.OTHER);
				break;
			case "fail":
				ps.setObject(7, gradetype.fail.toString(), Types.OTHER);
			case "presentation":
				ps.setObject(7, gradetype.presentation.toString(), Types.OTHER);
			}
	
			   LocalDateTime now = LocalDateTime.now(); 
			   Timestamp timestamp = Timestamp.valueOf(now);
			ps.setTimestamp(8, timestamp);
			ps.setInt(9, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new RequestTicket(
						rs.getString("status"),
						rs.getString("subject"),
						rs.getString("description"),
						rs.getDate("eventdate"),
						rs.getString("location"),
						rs.getDouble("cost"),
						rs.getString("eventtype"),
						rs.getString("grade"),
						rs.getDate("submissiontime"),
						rs.getInt("user_id"),
						rs.getInt("id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RequestTicket> getAllRequests(int userID){
		
		String sql = "select * from reimbursementapp.requests where user_id = ?";
		List<RequestTicket> requests = new ArrayList<>();
		try(Connection conn = cu.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				requests.add(new RequestTicket(
						rs.getString("status"),
						rs.getString("subject"),
						rs.getString("description"),
						rs.getDate("eventdate"),
						rs.getString("location"),
						rs.getDouble("cost"),
						rs.getString("eventtype"),
						rs.getString("grade"),
						rs.getDate("submissiontime"),
						rs.getInt("user_id"),
						rs.getInt("id")));
			}
			
			return requests;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public RequestTicket getSingleRequest(int userId, int requestId) {
		String sql = "select * from reimbursementapp.requests where user_id = ? and id = ?";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			ps.setInt(2, requestId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new RequestTicket(
						rs.getString("status"),
						rs.getString("subject"),
						rs.getString("description"),
						rs.getDate("eventdate"),
						rs.getString("location"),
						rs.getDouble("cost"),
						rs.getString("eventtype"),
						rs.getString("grade"),
						rs.getDate("submissiontime"),
						rs.getInt("user_id"),
						rs.getInt("id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<RequestTicket> getAllEmpRequests(){
		String sql = "select * from reimbursementapp.requests";
		List<RequestTicket> requests = new ArrayList<>();
		try(Connection conn = cu.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				requests.add(new RequestTicket(
						rs.getString("status"),
						rs.getString("subject"),
						rs.getString("description"),
						rs.getDate("eventdate"),
						rs.getString("location"),
						rs.getDouble("cost"),
						rs.getString("eventtype"),
						rs.getString("grade"),
						rs.getDate("submissiontime"),
						rs.getInt("user_id"),
						rs.getInt("id")));
			}
			
			return requests;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	public RequestTicket getReqById(int requestId) {
String sql = "select * from reimbursementapp.requests where id = ?";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, requestId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new RequestTicket(
						rs.getString("status"),
						rs.getString("subject"),
						rs.getString("description"),
						rs.getDate("eventdate"),
						rs.getString("location"),
						rs.getDouble("cost"),
						rs.getString("eventtype"),
						rs.getString("grade"),
						rs.getDate("submissiontime"),
						rs.getInt("user_id"),
						rs.getInt("id"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public RequestTicket statusUpdate(int requestId, String newStatus) {
		String sql = "UPDATE reimbursementapp.requests set status = ? where id = ? returning *";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setObject(1, newStatus, Types.OTHER);
			ps.setInt(2, requestId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new RequestTicket(
						rs.getString("status"),
						rs.getString("subject"),
						rs.getString("description"),
						rs.getDate("eventdate"),
						rs.getString("location"),
						rs.getDouble("cost"),
						rs.getString("eventtype"),
						rs.getString("grade"),
						rs.getDate("submissiontime"),
						rs.getInt("user_id"),
						rs.getInt("id"));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
