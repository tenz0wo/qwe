package tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import DAO.ClientDAO;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		ClientDAO clientDAO = new ClientDAO();
		assertNotNull(clientDAO, "123");
	}

}
