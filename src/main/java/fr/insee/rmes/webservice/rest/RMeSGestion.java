package fr.insee.rmes.webservice.rest;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.insee.rmes.exceptions.DDIAccessServicesException;
import fr.insee.rmes.gestion.model.Operation;
import fr.insee.rmes.gestion.model.Serie;
import fr.insee.rmes.gestion.service.GestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * Main WebService class of the gestion metadata service
 *
 */
@Component
@Path("/gestion")
@Api(value = "Gestion MetaData API")
@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success"), 
		@ApiResponse(code = 204, message = "No Content"),
		@ApiResponse(code = 500, message = "Internal server error") })
public class RMeSGestion {
	
	static final Logger logger = LogManager.getLogger(RMeSGestion.class);
	
	@Autowired
	GestionService gestionService;
	
	@GET
	@Path("series")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get the lists of series corresponding to a survey", notes = "Get the lists of series corresponding to a survey from API exposing gestion metadata", response = Serie.class)
	public Response getSeries() throws Exception {
		try {
			List<Serie> series = gestionService.getSeries();
			return Response.ok().entity(series).build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@GET
	@Path("serie/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get the lists of series corresponding to a survey", notes = "Get the lists of series corresponding to a survey from API exposing gestion metadata", response = Serie.class)
	public Response getSerieById(@PathParam(value = "id") String id) throws Exception {
		Serie serie = new Serie();
		try {
			serie = gestionService.getSerieById(id);
		} catch (DDIAccessServicesException e) {
			return Response.status(e.getStatus()).entity(e.getDetails()).type(TEXT_PLAIN).build();
		}
		return Response.ok().entity(serie).build();
	}
	
	@GET
	@Path("series/{id}/operations")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get the lists of series corresponding to a survey", notes = "Get the lists of series corresponding to a survey from API exposing gestion metadata", response = Serie.class)
	public Response getOperationsBySerie(@PathParam(value = "id") String id) throws Exception {
		List<Operation> operations = new ArrayList<>();
		try {
			operations = gestionService.getOperationsBySerieId(id);
			if (operations.isEmpty()) {
				return Response.status(HttpStatus.SC_NO_CONTENT).entity(operations).build();
			}
		} catch (DDIAccessServicesException e) {
			return Response.status(e.getStatus()).entity(e.getDetails()).type(TEXT_PLAIN).build();
		}
		return Response.ok().entity(operations).build();
	}

}
