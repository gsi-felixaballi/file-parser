package common.exception;

import org.apache.log4j.Logger;

public class ExceptionHandler {

    private final static Logger LOGGER = Logger.getLogger(ExceptionHandler.class);
    private static String message;
    private static Exception exception;
    private static ExceptionTypes type;

    private ExceptionHandler(String message, ExceptionTypes type) {
        this.message = message;
        this.exception = new Exception(message);
        this.type = type;
    }

    private ExceptionHandler(Exception exception, ExceptionTypes type) {
        this(exception.getMessage(), type);
        this.exception = exception;
    }

    public static ExceptionHandler from(String message, ExceptionTypes type) {
        return new ExceptionHandler(message, type);
    }

    public static ExceptionHandler from(Exception exception, ExceptionTypes type) {
        return new ExceptionHandler(exception, type);
    }

    public static String getMessage() {
        return message;
    }

    public static Exception getException() {
        return exception;
    }

    public void print() {
        LOGGER.error(exception.getMessage());
    }
}
