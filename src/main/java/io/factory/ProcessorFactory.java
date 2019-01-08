package io.factory;

import common.model.Expression;
import common.util.DataFormat;
import io.decode.FileDecoder;
import io.reduce.CityProcessor;
import io.reduce.FileProcessor;
import io.reduce.PeopleProcessor;

import java.util.ArrayList;
import java.util.List;

public class ProcessorFactory {
    private String[] args;
    private final static int CITY_ARG = 3;
    private final static int ID_ARG = 4;

    private ProcessorFactory(String[] args) {
        this.args = args;
    }

    public static ProcessorFactory from(String[] args) {
        return new ProcessorFactory(args);
    }

    public List create() {
        String file = args[0];
        String parameter = args[1];
        String value = args[2];

        FileProcessor processor;
        List result = new ArrayList();
        switch (parameter.toUpperCase()) {
            case "CITY":
                processor = new CityProcessor(file, value);
                result = processor.process(
                        new Expression(value, CITY_ARG),
                        new FileDecoder(file),
                        new DataFormat[]{DataFormat.DATA_PATTERN});
                break;
            case "ID":
                processor = new PeopleProcessor(file, value);
                result = processor.process(
                        new Expression(value, ID_ARG),
                        new FileDecoder(file),
                        new DataFormat[]{DataFormat.DATA_PATTERN});
                break;
        }

        return result;
    }
}
