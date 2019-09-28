//package ua.mycompany.task7.example1;
//
//import org.junit.Test;
//import ua.mycompany.task4.Helper.Validator.EmailValidator;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class EmailValidatorTest {
//
//    @Test
//    public void shouldReturnTrueIfEmailCorrect() {
//        assertFalse(EmailValidator.validate("fvfdgvdfvdf"));
//        assertFalse(EmailValidator.validate("fvdsv@"));
//        assertFalse(EmailValidator.validate("fvdsv@fdvfd"));
//        assertFalse(EmailValidator.validate("fvdsv@fdvfd."));
//        assertFalse(EmailValidator.validate("fvdsv@fdvfd.vfdvfd"));
//        assertFalse(EmailValidator.validate("fvdsv@fdvfd.vfdvfd."));
//        assertFalse(EmailValidator.validate("fvdsvfdvfd.vfdvfd."));
//        assertFalse(EmailValidator.validate("fvdsvfdvfd@.gmail.com"));
//        assertFalse(EmailValidator.validate("fvdsvfdvfd.@gmail.com"));
//
//        assertTrue(EmailValidator.validate("fvdsvfdvfd@gmail.com"));
//    }
//}