package ua.mycompany.task4.init;

import ua.mycompany.task4.domain.Address;
import ua.mycompany.task4.domain.Department;
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
                .withName("Name")
                .withSurname("Surname")
                .withBirthday(LocalDate.of(2002,4,4))
                .withAddress(new Address("city", "street", 10))
                .withDepartment(department)
                .withPhoneNumber("380444747474")
                .withGroup("AA-11")
                .withCourse(1)
                .withEmail("dsadas@gmail.com")
                .build();

        Student student2 = Student.builder()
                .withName("Kick")
                .withSurname("Shevchenko")
                .withBirthday(LocalDate.of(1999, 3, 3))
                .withAddress(new Address("Kyiv", "Lviv", 2))
                .withDepartment(department)
                .withPhoneNumber("380444743334")
                .withGroup("AA-22")
                .withCourse(4)
                .withEmail("email@gmail.com")
                .build();

        Student student3 = Student.builder()
                .withName("Tom")
                .withSurname("King")
                .withBirthday(LocalDate.of(1999, 3, 23))
                .withAddress(new Address("Kyiv", "street", 12))
                .withDepartment(department)
                .withPhoneNumber("380444744444")
                .withGroup("AA-22")
                .withCourse(4)
                .withEmail("tomking@gmail.com")
                .build();

        studentService.register(student1);
        studentService.register(student2);
        studentService.register(student3);
    }
}
