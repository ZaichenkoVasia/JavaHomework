package ua.mycompany.task4.Helper.Validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorFactoryTest {

    @Test
    public void shouldReturnCorrectValidator() {
        assertEquals(ValidatorFactory.getValidator("name").getClass(), NameValidator.class);
        assertEquals(ValidatorFactory.getValidator("course").getClass(), CourseValidator.class);
        assertEquals(ValidatorFactory.getValidator("email").getClass(), EmailValidator.class);
        assertEquals(ValidatorFactory.getValidator("date").getClass(), DateValidator.class);
        assertEquals(ValidatorFactory.getValidator("phoneNumber").getClass(), PhoneValidator.class);
        assertEquals(ValidatorFactory.getValidator("surname").getClass(), SurnameValidator.class);
    }
}
