package fr.insee.rmes.gestion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserInputValidation {

	static final Logger logger = LogManager.getLogger(UserInputValidation.class);

	private UserInputValidation() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean validateSerieId(String id) {
		final Pattern pattern = Pattern.compile("^[a-z]\\d{4}$");
		final Matcher matcher = pattern.matcher(id);

		return matcher.matches();
	}

}
