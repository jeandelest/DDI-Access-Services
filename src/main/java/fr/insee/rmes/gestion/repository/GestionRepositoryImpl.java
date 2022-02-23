package fr.insee.rmes.gestion.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insee.rmes.gestion.client.GestionClient;
import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Serie;

@Service
public class GestionRepositoryImpl implements GestionRepository{
	
	private static final Logger logger = LogManager.getLogger(GestionRepositoryImpl.class);
	
	@Autowired
	GestionClient gestionClient;
	
	public List<Serie> getSeries() throws Exception {
		return gestionClient.getSeries();		
	}
	
	public Serie getSerieById(String id) throws Exception{
		return gestionClient.getSerieById(id);
	}
	
	public List<Operation> getOperationsBySerieId(String id) throws Exception {
		return gestionClient.getOperationsBySerieId(id);		
	}
	
	public Operation getOperationById(String id) throws Exception{
		return gestionClient.getOperationById(id);
	}

}
