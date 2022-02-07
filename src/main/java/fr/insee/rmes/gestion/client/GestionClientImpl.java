package fr.insee.rmes.gestion.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Serie;

@Service
public class GestionClientImpl implements GestionClient{
	
	private static final Logger logger = LogManager.getLogger(GestionClientImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${fr.insee.rmes.api.remote.gestion.url}")
	String gestionMetadataUrl;

	public List<Serie> getSeries() throws Exception {
		String url = String.format("%s/operations/series?survey=true", gestionMetadataUrl);
		logger.info("GET series from gestion metadata API");
		ResponseEntity<Serie[]> response;
		response = restTemplate.exchange(url, HttpMethod.GET, null, Serie[].class);
		return Arrays.asList(response.getBody());
	}
	
	public Serie getSerieById(String id) throws Exception {
		String url = String.format("%s/operations/serie/%s/", gestionMetadataUrl, id);
		logger.info("GET serie {} from gestion metadata API", id);
		ResponseEntity<Serie> response;
		response = restTemplate.exchange(url, HttpMethod.GET, null, Serie.class);
		return response.getBody();
	}
	
	public List<Operation> getOperationsBySerieId(String id) throws Exception {
		String url = String.format("%s/operations/serie/%s/operations", gestionMetadataUrl, id);
		logger.info("GET operations for serie : {}", id);
		ResponseEntity<Operation[]> response;
		response = restTemplate.exchange(url, HttpMethod.GET, null, Operation[].class);
		return Arrays.asList(response.getBody());
	}

}
