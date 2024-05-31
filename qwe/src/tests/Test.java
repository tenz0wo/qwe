package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import DAO.ClientDAO;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		ClientDAO clientDAO = new ClientDAO();
		assertNotNull(clientDAO, "123");
	}
	
	@org.junit.jupiter.api.Test
	void test1() {
		ClientDAO clientDAO = new ClientDAO();
		assertEquals(clientDAO, new ClientDAO());
	}

}
