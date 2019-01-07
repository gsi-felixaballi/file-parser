package io.reduce;

import common.exception.ExceptionHandler;
import common.exception.ExceptionTypes;
import common.model.Expression;
import common.util.DataFormat;
import io.decode.Decoder;
import io.split.Splitter;

import java.util.List;

import static java.util.Objects.requireNonNull;

public interface FileProcessor {

    String file();

    default String format(Splitter splitter) {
        try {
            return requireNonNull(splitter).format();
        } catch (Exception e) {
            ExceptionHandler.from(e, ExceptionTypes.MISSING_CONFIGURATION).print();
        }
        return null;
    }

    List process(Expression expression, Decoder decoder, DataFormat[] formats);
}
