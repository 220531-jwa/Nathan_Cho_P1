package dev.cho.service;

import dev.cho.model.User;
import dev.cho.repositories.UserDAO;

public class UserService {
	private static UserDAO userDao;
	
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public User getUserById(int id) throws Exception {
		
		User c =  userDao.getClientByID(id);
		
		return c;
	}
	
	public User checkUandP(String username, String password) {
		
		return userDao.checkUandP(username, password);
		
	}
	
	public User createUser(User u) {

		return userDao.createUser(u);
	}
}
