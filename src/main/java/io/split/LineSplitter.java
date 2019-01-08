package io.split;

import com.google.common.base.Strings;
import common.exception.ExceptionHandler;
import common.exception.ExceptionTypes;
import common.model.Expression;
import common.model.PeopleTuple;
import common.util.DataFormat;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineSplitter {

    private String line;

    public LineSplitter(String line) {
        this.line = line;
    }

    public PeopleTuple extract(Expression expression, DataFormat[] formats) {
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

    private static PeopleTuple chunks(String content, Expression expression, DataFormat format) {
        Matcher matcher = format.pattern().matcher(content);

        PeopleTuple result = null;
        while (matcher.find()) {
            for (int i = 1; i < matcher.groupCount(); i++) {
                String replaced = matcher.group(i).replaceAll("[,;]*", "");
                if (i == expression.getGroup() && replaced.equalsIgnoreCase(expression.getExpression())) {
                    result = new PeopleTuple(
                            matcher.group(4).replaceAll("[,;]*", "").trim(),
                            matcher.group(2).replaceAll("[,;]*", "").trim(),
                            matcher.group(3).replaceAll("[,;]*", "").trim());
                    break;
                }
            }
        }

        return result;
    }
}
