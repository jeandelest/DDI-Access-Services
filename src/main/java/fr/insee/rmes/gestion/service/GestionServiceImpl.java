package fr.insee.rmes.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insee.rmes.exceptions.DDIAccessServicesException;
import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Serie;
import fr.insee.rmes.gestion.repository.GestionRepository;

@Service
public class GestionServiceImpl implements GestionService{
	
	@Autowired
	GestionRepository gestionRepository;
	
	private static final String IDSERIE_PATTERN="^[a-z]\\d{4}$";
	private static final String INVALID_IDENTIFER = "Invalid identifier";
    private static final String MESSAGE_INVALID_IDENTIFIER = "Identifier %s is invalid";

	
	public List<Serie> getSeries() throws Exception{
		return gestionRepository.getSeries();
	}
	
	public Serie getSerieById(String id) throws Exception{
		if (id.matches(IDSERIE_PATTERN)) {
			return gestionRepository.getSerieById(id);
		} else {
			throw new DDIAccessServicesException(500,INVALID_IDENTIFER,String.format(MESSAGE_INVALID_IDENTIFIER,id));
		}
	}
	
	public List<Operation> getOperationsBySerieId(String id) throws Exception{
		if (id.matches(IDSERIE_PATTERN)) {
			return gestionRepository.getOperationsBySerieId(id);
		} else {
			throw new DDIAccessServicesException(500,INVALID_IDENTIFER,String.format(MESSAGE_INVALID_IDENTIFIER,id));
		}
	}
	
	public Operation getOperationById(String id) throws Exception{
		if (id.matches(IDSERIE_PATTERN)) {
			return gestionRepository.getOperationById(id);
		} else {
			throw new DDIAccessServicesException(500,INVALID_IDENTIFER,String.format(MESSAGE_INVALID_IDENTIFIER,id));
		}
	}
	
}
