package ua.mycompany.task4.Helper.Validator;

public final class ValidatorFactory {

    public static Validator getValidator(String field) {
        switch (field) {
            case "email":
                return new EmailValidator();
            case "name":
                return new NameValidator();
            case "surname":
                return new SurnameValidator();
            case "phoneNumber":
                return new PhoneValidator();
            case "date":
                return new DateValidator();
            case "course":
                return new CourseValidator();
        }
        throw new IllegalArgumentException();
    }
}
