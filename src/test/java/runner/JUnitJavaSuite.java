package runner;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import Repositories.RequestTicketDAOtests;
import Repositories.UserDAOTests;
import Services.RequesTicketServiceTests;
import Services.UserServicestests;



@Suite
@SelectClasses({RequestTicketDAOtests.class, UserDAOTests.class, RequesTicketServiceTests.class, UserServicestests.class})
public class JUnitJavaSuite {
	
}
