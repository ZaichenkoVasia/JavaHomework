package ua.mycompany.task4.Helper.Validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {

    @Test
    public void shouldReturnTrueIfEmailCorrect() {
        EmailValidator emailValidator = new EmailValidator();
        assertFalse(emailValidator.validate("fvfdgvdfvdf"));
        assertFalse(emailValidator.validate("fvdsv@"));
        assertFalse(emailValidator.validate("fvdsv@fdvfd"));
        assertFalse(emailValidator.validate("fvdsv@fdvfd."));
        assertFalse(emailValidator.validate("fvdsv@fdvfd.vfdvfd"));
        assertFalse(emailValidator.validate("fvdsv@fdvfd.vfdvfd."));
        assertFalse(emailValidator.validate("fvdsvfdvfd.vfdvfd."));
        assertFalse(emailValidator.validate("fvdsvfdvfd@.gmail.com"));
        assertFalse(emailValidator.validate("fvdsvfdvfd.@gmail.com"));

        assertTrue(emailValidator.validate("fvdsvfdvfd@gmail.com"));
    }
}
