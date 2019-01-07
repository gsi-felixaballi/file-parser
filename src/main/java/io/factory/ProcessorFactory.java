package io.factory;

import common.model.Expression;
import common.util.DataFormat;
import io.FileEntry;
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

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public List create() {
        String file = args[0];
        String parameter = args[1];
        String value = args[2];

        List result = new ArrayList();
        if (parameter.equalsIgnoreCase("CITY")) {
            FileProcessor processor = new CityProcessor(file, value);

            result = processor.process(
                    new Expression(value, CITY_ARG),
                    new FileDecoder(
                            new FileEntry(file)), new DataFormat[]{
                            DataFormat.DATA_PATTERN
                    });
        } else if (parameter.equalsIgnoreCase("ID")) {
            FileProcessor processor = new PeopleProcessor(file, value);
            result = processor.process(
                    new Expression(value, ID_ARG),
                    new FileDecoder(
                            new FileEntry(file)), new DataFormat[]{
                            DataFormat.DATA_PATTERN
                    });
        }

        return result;
    }
}
