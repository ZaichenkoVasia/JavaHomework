package ua.mycompany.task4.Helper.Validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public final class NameValidator implements Validator {
    private static final String NAME_PATTERN = "[a-zA-Z]{2,}";

    public NameValidator() {

    }

    @Override
    public boolean validate(final String hex) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
