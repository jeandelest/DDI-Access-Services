package fr.insee.rmes.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insee.rmes.exceptions.DDIAccessServicesException;
import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Serie;
import fr.insee.rmes.gestion.repository.GestionRepository;
import fr.insee.rmes.gestion.utils.UserInputValidation;

@Service
public class GestionServiceImpl implements GestionService{
	
	@Autowired
	GestionRepository gestionRepository;
	
	public List<Serie> getSeries() throws Exception{
		return gestionRepository.getSeries();
	}
	
	public Serie getSerieById(String id) throws Exception{
		if (UserInputValidation.validateSerieId(id)) {
			return gestionRepository.getSerieById(id);
		} else {
			throw new DDIAccessServicesException(500,"Invalid identifier","Identifier "+id+" is invalid");
		}
	}
	
	public List<Operation> getOperationsBySerieId(String id) throws Exception{
		if (UserInputValidation.validateSerieId(id)) {
			return gestionRepository.getOperationsBySerieId(id);
		} else {
			throw new DDIAccessServicesException(500,"Invalid identifier","Identifier "+id+" is invalid");
		}
	}
	
}
