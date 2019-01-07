package io.reduce;

import common.model.Expression;
import common.util.DataFormat;
import io.decode.Decoder;

import java.util.List;

public class CityProcessor implements FileProcessor {

    private final String file;
    private final String personId;

    public CityProcessor(String file, String personId) {
        this.file = file;
        this.personId = personId;
    }

    public String getFile() {
        return file;
    }

    public String getPersonId() {
        return personId;
    }

    @Override
    public String file() {
        return file;
    }

    @Override
    public List process(Expression expression, Decoder decoder, DataFormat[] formats) {
        return decoder.decode(expression, formats);
    }
}
