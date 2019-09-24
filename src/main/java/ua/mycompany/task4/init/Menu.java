package ua.mycompany.task4.init;

import ua.mycompany.task4.domain.Address;
import ua.mycompany.task4.domain.Department;
import ua.mycompany.task4.domain.PhoneNumber;
import ua.mycompany.task4.domain.Student;
import ua.mycompany.task4.repository.StudentRepositoryImpl;
import ua.mycompany.task4.service.StudentService;
import ua.mycompany.task4.service.StudentServiceImpl;

import java.time.LocalDate;

public class Menu {
    private StudentService studentService = StudentServiceImpl.getInstance(StudentRepositoryImpl.getInstance());

    public void run(){
        Department department = new Department(1L,"Dep1");

        Student student1 = Student.builder()
                .withId(1L)
                .withName("Name")
                .withSurname("Surname")
                .withBirthday(LocalDate.of(2002,4,4))
                .withAddress(new Address("city", "street", 10))
                .withDepartment(department)
                .withPhoneNumber(new PhoneNumber(38044, 4747474))
                .withGroup("AA-11")
                .withCourse(1)
                .build();

        Student student2 = Student.builder()
                .withId(2L)
                .withName("Taras")
                .withSurname("Shevchenko")
                .withBirthday(LocalDate.of(1999, 3, 3))
                .withAddress(new Address("Kyiv", "Lviv", 2))
                .withDepartment(department)
                .withPhoneNumber(new PhoneNumber(38044, 4743334))
                .withGroup("AA-22")
                .withCourse(4)
                .build();

        Student student3 = Student.builder()
                .withId(3L)
                .withName("Tom")
                .withSurname("King")
                .withBirthday(LocalDate.of(1999, 3, 23))
                .withAddress(new Address("Kyiv", "street", 12))
                .withDepartment(department)
                .withPhoneNumber(new PhoneNumber(38044, 4744444))
                .withGroup("AA-22")
                .withCourse(4)
                .build();

        studentService.register(student1);
        studentService.register(student2);
        studentService.register(student3);
    }
}
