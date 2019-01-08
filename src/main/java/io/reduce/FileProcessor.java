package io.reduce;

import common.model.Expression;
import common.util.DataFormat;
import io.decode.Decoder;

import java.util.List;

public interface FileProcessor {

    List process(Expression expression, Decoder decoder, DataFormat[] formats);
}
