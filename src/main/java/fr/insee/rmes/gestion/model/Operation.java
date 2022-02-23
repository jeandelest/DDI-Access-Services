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
	
	@Getter @Setter
	@JsonProperty("serie")
	Serie serie;

	@Override
	public String toString() {
		return "Operation [labels=" + labels + ", id=" + id + ", serie=" + serie + "]";
	}

}
