package runner;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import Repositories.RequestTicketDAOtests;
import Repositories.UserDAOTests;



@Suite
@SelectClasses({RequestTicketDAOtests.class, UserDAOTests.class})
public class JUnitJavaSuite {
	
}
