package ua.mycompany.task4.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void shouldReturnCopyStudent() {
        Department department = new Department(1L, "dep");
        Student studentOld = Student.builder()
                .withId(1L)
                .withName("Name")
                .withSurname("Surname")
                .withBirthday(LocalDate.of(2002, 4, 4))
                .withAddress(new Address("city", "street", 10))
                .withDepartment(department)
                .withPhoneNumber("380444747474")
                .withGroup("AA-11")
                .withCourse(1)
                .withEmail("dsadas@gmail.com")
                .withPassword("oldPassword")
                .build();

        Student studentExpected = Student.builder()
                .withId(1L)
                .withName("Name")
                .withSurname("Surname")
                .withBirthday(LocalDate.of(2002, 4, 4))
                .withAddress(new Address("city", "street", 10))
                .withDepartment(department)
                .withPhoneNumber("380444747474")
                .withGroup("AA-11")
                .withCourse(1)
                .withEmail("dsadas@gmail.com")
                .withPassword("newPassword")
                .build();

        Student studentActual = (Student) studentOld.clone("newPassword");
        assertEquals(studentExpected, studentActual);

    }
}
