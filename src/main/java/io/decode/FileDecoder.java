package io.decode;

import common.exception.ExceptionHandler;
import common.exception.ExceptionTypes;
import common.model.Expression;
import common.model.PeopleTuple;
import common.util.DataFormat;
import io.split.LineSplitter;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileDecoder implements Decoder<PeopleTuple> {

    private final String path;

    public FileDecoder(String path) {
        this.path = path;
    }

    @Override
    public List<PeopleTuple> decode(Expression expression, DataFormat[] formats) {
        List<PeopleTuple> items = new ArrayList<>();

        Path path = Paths.get(this.path);
        if (!path.toFile().exists())
            return items;

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path.toString()), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                LineSplitter splitter = new LineSplitter(line.trim());
                PeopleTuple result = splitter.extract(expression, formats);
                if (!Objects.isNull(result))
                    items.add(result);
            }
        } catch (Exception e) {
            ExceptionHandler.from(e, ExceptionTypes.NOT_FOUND);
        }
        return new ArrayList<>(items);
    }
}
