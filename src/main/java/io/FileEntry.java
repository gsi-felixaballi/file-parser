package io;

import common.exception.ExceptionHandler;
import common.exception.ExceptionTypes;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEntry {

    private String path;

    public FileEntry(String path) {
        this.path = path;
    }

    public String filename() {
        Path path = Paths.get(path());
        try {
            if (!path.toFile().exists())
                throw new IOException("Missing file");
            return String.valueOf(path.getFileName());
        } catch (Exception e) {
            ExceptionHandler.from(e, ExceptionTypes.IO_ERROR).print();
        }
        return null;
    }

    public String path() {
        Path path = Paths.get(this.path);
        try {
            if (!path.toFile().exists())
                throw new IOException("Missing file");
            return String.valueOf(path);
        } catch (Exception e) {
            ExceptionHandler.from(e, ExceptionTypes.IO_ERROR).print();
        }
        return null;
    }
}
