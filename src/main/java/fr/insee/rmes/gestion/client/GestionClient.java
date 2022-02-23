package fr.insee.rmes.gestion.client;

import java.util.List;

import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Serie;

public interface GestionClient {
	
	List<Serie> getSeries() throws Exception;
	
	Serie getSerieById(String id) throws Exception;
	
	List<Operation> getOperationsBySerieId(String id) throws Exception;
	
	Operation getOperationById(String id) throws Exception;

}
