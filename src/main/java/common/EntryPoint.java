package common;

import common.exception.ExceptionTypes;
import io.factory.ProcessorFactory;

import java.io.IOException;
import java.util.List;

public class EntryPoint {
    private final static int ARGS_LEN = 3;

    public static void main(String[] args) throws IOException {

        while (args.length < ARGS_LEN) {
            System.out.println(ExceptionTypes.MISSING_CONFIGURATION);
            System.in.read();
        }

        List output = ProcessorFactory.from(args).create();
        System.out.println(output);
    }
}
