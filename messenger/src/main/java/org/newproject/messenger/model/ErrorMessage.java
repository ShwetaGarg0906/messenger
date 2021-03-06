package org.newproject.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	String errorMessage;
	int errorCode;
	String description;
	
	ErrorMessage(){
		
	}

	public ErrorMessage(String errorMessage, int errorCode, String description) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.description = description;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
