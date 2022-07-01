package Repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.cho.model.User;
import dev.cho.repositories.UserDAO;

@ExtendWith(MockitoExtension.class)
public class UserDAOTests {

	private static UserDAO userDao;
	
	@BeforeEach
	public void setUp() {
		userDao = new UserDAO();
	}
	
	@Test
	public void getUserByIDNotNull() {
		assertNotNull(userDao.getUserByID(1));
	}
	
	@Test
	public void getUserByIDNullInvalidId() {
		assertNull(userDao.getUserByID(0));
	}
	
	@Test
	public void createUserMakesUser() {
		int x = 1;
		String username = "JUnitTest";
		String password = "testpassword";
		String name = "Junit";
		int accessLevel = 1;
		
		
		User mockUser = new User(x, username, password, name, accessLevel);
		assertNotNull(userDao.createUser(mockUser));
		
	}

	@Test
	public void createUserNullWhenInvalid() {
		
		User mockUser = new User();
		assertNull(userDao.createUser(mockUser));
	}

	@Test
	public void checkUandPNotNullWhenValid() {
		
		String username = "josh";
		String password = "josh";
		
		assertNotNull(userDao.checkUandP(username, password));
	}
	
	@Test
	public void checkUandPNullWhenInvalid() {
		String username = "joshiewoshie";
		String password = "josh";
		
		assertNull(userDao.checkUandP(username, password));
	}
}
