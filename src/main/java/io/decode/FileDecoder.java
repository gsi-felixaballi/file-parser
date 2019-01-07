package io.decode;

import common.exception.ExceptionHandler;
import common.exception.ExceptionTypes;
import common.model.Expression;
import common.util.DataFormat;
import io.FileEntry;
import io.split.LineSplitter;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileDecoder implements Decoder<Object> {

    private final FileEntry entry;

    public FileDecoder(FileEntry entry) {
        this.entry = entry;
    }

    @Override
    public List decode(Expression expression, DataFormat[] formats) {
        List<List> items = new ArrayList<>();
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(entry.path()), charset)) {

            String line;
            while ((line = reader.readLine()) != null) {
                LineSplitter splitter = new LineSplitter(line.trim());
                List<Object> parts = splitter.extract(expression, formats);
                if (!Objects.isNull(parts) && !parts.isEmpty())
                    items.add(parts);
            }
        } catch (Exception e) {
            ExceptionHandler.from(e, ExceptionTypes.IO_ERROR);
        }
        return items.stream()
                .filter(item -> !Objects.isNull(item) && !item.isEmpty())
                .collect(Collectors.toList());
    }
}
