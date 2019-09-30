package ua.mycompany.task4.Helper.Validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DateValidator implements Validator {
    private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    public DateValidator() {

    }

    @Override
    public boolean validate(final String hex) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
