package common.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DataFormat {
    HEADER_PATTERN("^F\\d+$"),
    DATA_PATTERN("^(D\\s+)([A-z\\s]+[,;]\\s*)([A-z\\s]+[,;]\\s*)(\\d{8}(-)?[A-Z])$"); //D Lowell Miles,BARCELONA,04217040J

    private String format;

    DataFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public static List<String> formats() {
        return Arrays.stream(DataFormat.values()).map(String::valueOf).collect(Collectors.toList());
    }
}
