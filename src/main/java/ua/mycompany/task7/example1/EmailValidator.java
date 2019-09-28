package ua.mycompany.task7.example1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EmailValidator {
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9]{1,}[@]{1}[a-z]{5,}[.]{1}+[a-z]{3}";

    private EmailValidator() {

    }

    public static boolean validate(final String hex) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
