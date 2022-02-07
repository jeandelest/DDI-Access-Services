package fr.insee.rmes.gestion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Serie {
	
	@Getter
	@Setter
	@JsonProperty("label")
	List<Label> labels;
	
	@Getter
	@Setter
	@JsonProperty("id")
	String id;
	
	@Getter
	@Setter
	@JsonProperty("frequence")
	List<Frequence> frequences;

	@Override
	public String toString() {
		return "Serie [labels=" + labels + ", id=" + id + ", frequence=" + frequences + "]";
	}



}
