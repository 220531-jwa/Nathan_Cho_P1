package dev.cho.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.cho.model.User;
import dev.cho.utils.ConnectionUtil;

public class UserDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public User getClientByID(int id) {
		
		String sql = "select * from reimbursementapp.users where id = ?";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getInt("access_lvl"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User createUser(User newUser) {
		String sql = "insert into reimbursementapp.users values (default, ?, ?, ?, ?) returning *";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.getUsername());
			ps.setString(2, newUser.getPassword());
			ps.setString(3, newUser.getName());
			ps.setInt(4, newUser.getAccLvl());
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getInt("access_lvl"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public User checkUandP(String username, String password) {
		String sql = "select * from reimbursementapp.users where username = ? and password = ?";
		
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			return new User(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("password"), 
					rs.getString("name"), 
					rs.getInt("access_lvl"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
