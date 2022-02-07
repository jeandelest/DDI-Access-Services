package fr.insee.rmes.gestion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Operation {
	
	@Getter
	@Setter
	@JsonProperty("label")
	List<Label> labels;
	
	@Getter
	@Setter
	@JsonProperty("id")
	String id;

	@Override
	public String toString() {
		return "Serie [labels=" + labels + ", id=" + id + "]";
	}

}