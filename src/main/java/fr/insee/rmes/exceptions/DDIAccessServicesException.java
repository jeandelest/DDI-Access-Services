package fr.insee.rmes.exceptions;

import fr.insee.rmes.webservice.rest.RestMessage;
import lombok.Getter;
import lombok.Setter;

public class DDIAccessServicesException extends Exception {

	private static final long serialVersionUID = 6672048722210118333L;
	
	@Getter @Setter
	private int status;
	
	@Getter @Setter
	private String details;

	/**
	 *
	 * @param status
	 * @param message
	 * @param details
	 */
	public DDIAccessServicesException(int status, String message, String details) {
		super(message);
		this.status = status;
		this.details = details;
	}
	
    public RestMessage toRestMessage(){
        return new RestMessage(this.status, this.getMessage(), this.details);
    }

}
