package org.newproject.messenger.exception;

public class DataNotFoundException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DataNotFoundException(long msgId){
		super( "DataNotFound at messageId"+msgId);
	}
}
