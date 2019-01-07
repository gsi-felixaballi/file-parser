package io.decode;

import common.model.Expression;
import common.util.DataFormat;

import java.util.List;

public interface Decoder<T> {
    List<T> decode(Expression expression, DataFormat[] format);
}
