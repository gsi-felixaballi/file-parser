package common.exception;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum ExceptionTypes {

    IO_ERROR("I/O: READ/WRITE ERROR"),
    PROCESSOR_ERROR("PROCESSOR: MISSING HANDLER"),
    NOT_FOUND("FILE/URI: RESOURCE NOT FOUND"),
    CONTENT_TYPE("FILE/URI: UNKNOWN CONTENT TYPE"),
    EMPTY_FILE("FILE/URI: RESOURCE IS EMPTY"),
    MISSING_CONFIGURATION("I/O: MISSING CONFIGURATION ERROR");

    private String exceptionMessage;

    ExceptionTypes(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public static Set<String> types() {
        return Arrays.stream(ExceptionTypes.values()).map(String::valueOf).collect(Collectors.toSet());
    }
}
