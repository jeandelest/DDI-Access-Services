package fr.insee.rmes.gestion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.insee.rmes.exceptions.DDIAccessServicesException;

class GestionServiceImplTest {
	
	@Test
	@DisplayName("Exception should be thrown in getSerieById() when id is invalid")
	void getSerieByIdTestException() {
		GestionService gestionService = new GestionServiceImpl();
		DDIAccessServicesException exception = assertThrows(DDIAccessServicesException.class,
				() ->  gestionService.getSerieById("s1200x6"),
				"Excepted getSerieById() to throw DDIAccessServices Exception but didn't");
		assertEquals("Invalid identifier",exception.getMessage());
	}
	
	@Test
	@DisplayName("Exception should be thrown in getOperationsBySerieId() when id is invalid")
	void getOperationsBySerieIdTestException() {
		GestionService gestionService = new GestionServiceImpl();
		DDIAccessServicesException exception = assertThrows(DDIAccessServicesException.class,
				() ->  gestionService.getOperationsBySerieId("s1200x6"),
				"Excepted getOperationsBySerieId() to throw DDIAccessServices Exception but didn't");
		assertEquals("Invalid identifier",exception.getMessage());
	}
}
