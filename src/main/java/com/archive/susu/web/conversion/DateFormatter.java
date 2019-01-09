package com.archive.susu.web.conversion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

    @Value("${date.format}")
    private String DATE_FORMAT_PATTERN;

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        final SimpleDateFormat dateFormat = createDateFormat();
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        final SimpleDateFormat dateFormat = createDateFormat();
        return dateFormat.format(object);
    }

    private SimpleDateFormat createDateFormat() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}
