package com.jo.registration.errorHandling;

import com.jo.registration.logging.Logging;

public final class ErrorHandling extends Exception{
	
	    public ErrorHandling(String message) {
	        super(message);
	        Logging.logger.error(message);
	    }

	    public ErrorHandling(String message, Throwable cause) {
	        super(message, cause);
	        Logging.logger.error(message);
	    }
	}


