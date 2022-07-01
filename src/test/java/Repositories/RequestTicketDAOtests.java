package Repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.cho.model.RequestTicket;
import dev.cho.repositories.RequestDAO;

@ExtendWith(MockitoExtension.class)
public class RequestTicketDAOtests {
	
	private static RequestDAO rd;
	
	@BeforeEach
	public void setUp() {
		rd = new RequestDAO();
	}
	
	@Test
	public void createTicketMakesTicket() {

		String st = "resolved";
		String su = "Junit-Test";
		String desc = "Junit-Test";
		LocalDate nowi = LocalDate.now();
		Date now = Date.valueOf(nowi);
		Date eventDate = now;
		String location = "test";
		Double cost = 0D;
		String eventType = "JUnit Test";
		String grade = "pass";
		Date sT = now;
		int userId = 12;
		int id = 0;
		
		RequestTicket mock = new RequestTicket(st, su, desc, eventDate, location, cost, eventType, grade, sT, userId, id);
		
		assertNotNull(rd.createTicket(mock, userId));
		
	}
	
	@Test
	public void createTicketIsNullInvalidId() {
		
		RequestTicket mock = new RequestTicket();
		assertNull(rd.createTicket(mock, 0));
	}
	
	@Test
	public void getAllRequestsIsValid() {
		
		assertNotNull(rd.getAllRequests(12));
	}
	
	@Test
	public void getAllRequestsNotValidID() {
		assertNull(rd.getAllRequests(0));
	}
	
	@Test
	public void getSingleRequestValid() {
		assertNotNull(rd.getSingleRequest(12, 9));
	}
	
	@Test
	public void getSingleRequestInvalid() {
		assertNull(rd.getSingleRequest(12, 1));
	}
	
	@Test
	public void getAllEmpRequestsValid() {
		assertNotNull(rd.getAllEmpRequests());
	}
	
	@Test
	public void getReqByIdValid() {
		assertNotNull(rd.getReqById(9));
	}
	
	@Test
	public void getReqByIdInValid() {
		assertNull(rd.getReqById(0));
	}
	
	@Test 
	public void statusUpdateIsValid(){
		assertNotNull(rd.statusUpdate(9, "resolved"));
	}
	
	@Test
	public void statusUpdateInvalidID() {
		assertNull(rd.statusUpdate(0, "help"));
	}
	
	@Test
	public void updateRequestIsValid(){
		
		String st = "resolved";
		String su = "Junit-Test";
		String desc = "Junit-Test";
		LocalDate nowi = LocalDate.now();
		Date now = Date.valueOf(nowi);
		Date eventDate = now;
		String location = "test";
		Double cost = 0D;
		String eventType = "JUnit Test";
		String grade = "pass";
		Date sT = now;
		int userId = 12;
		int id = 0;
		
		RequestTicket mock = new RequestTicket(st, su, desc, eventDate, location, cost, eventType, grade, sT, userId, id);
		
		assertNotNull(rd.updateRequest(12, 9, mock));
	}
	
	@Test
	public void updateRequestInValid() {
		assertNull(rd.updateRequest(0, 0, null));
	}
}
