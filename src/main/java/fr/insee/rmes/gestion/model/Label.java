package fr.insee.rmes.gestion.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Label {
	
	@Getter
	@Setter
	@JsonProperty("langue")
	String language;
	
	@Getter
	@Setter
	@JsonProperty("contenu")
	String content;

	@Override
	public String toString() {
		return "Label [language=" + language + ", content=" + content + "]";
	}

}
