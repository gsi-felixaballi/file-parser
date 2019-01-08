package io.reduce;

import common.model.Expression;
import common.util.DataFormat;
import io.decode.Decoder;

import java.util.List;

public class PeopleProcessor implements FileProcessor {

    private final String file;
    private final String city;

    public PeopleProcessor(String file, String city) {
        this.file = file;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public List process(Expression expression, Decoder decoder, DataFormat[] formats) {
        return decoder.decode(expression, formats);
    }
}
