package io.split;

import com.google.common.base.Strings;
import common.exception.ExceptionHandler;
import common.exception.ExceptionTypes;
import common.model.Expression;
import common.model.PeopleTuple;
import common.util.DataFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class LineSplitter implements Splitter {

    private String line;

    public LineSplitter(String line) {
        this.line = line;
    }

    @Override
    public String format() {
        return DataFormat.DATA_PATTERN.name();
    }

    @Override
    public List extract(Expression expression, DataFormat[] formats) {
        try {
            if (Strings.isNullOrEmpty(line)) throw new IOException(String.valueOf(ExceptionTypes.CONTENT_TYPE));

            for (DataFormat format : formats) {
                String regex = format.getFormat();
                Matcher matcher = Pattern.compile(regex).matcher(this.line);
                if (matcher.matches())
                    return chunks(this.line, expression, format);
            }

        } catch (Exception e) {
            ExceptionHandler.from(e, ExceptionTypes.CONTENT_TYPE).print();
        }
        return null;
    }

    private static List chunks(String content, Expression expression, DataFormat format) {
        Pattern pattern = Pattern.compile(format.getFormat());
        Matcher matcher = pattern.matcher(content);

        final List<PeopleTuple> chunks = new ArrayList<>();
        while (matcher.find()) {
            IntStream.range(1, matcher.groupCount())
                    .forEach(group -> {
                        String replaced = matcher.group(group).replaceAll("[,;]*", "");
                        if (group == expression.getGroup() && replaced.equalsIgnoreCase(expression.getExpression())) {
                            chunks.add(new PeopleTuple(
                                    matcher.group(4).replaceAll("[,;]*", "").trim(),
                                    matcher.group(2).replaceAll("[,;]*", "").trim(),
                                    matcher.group(3).replaceAll("[,;]*", "").trim())
                            );
                        }
                    });
        }

        return chunks;
    }
}
