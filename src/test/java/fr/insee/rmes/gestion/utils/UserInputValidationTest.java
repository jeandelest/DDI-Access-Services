package fr.insee.rmes.gestion.utils;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

class UserInputValidationTest {
	
	@Test
	void validateSerieIdSuccess() {
		assumeTrue(UserInputValidation.validateSerieId("s1022"));
	}
	
	@Test
	void validateSerieIdFailure() {
		assumeFalse(UserInputValidation.validateSerieId("s1022x56"));
	}

}
