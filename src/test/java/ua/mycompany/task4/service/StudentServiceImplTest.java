package ua.mycompany.task4.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.mycompany.task4.Helper.Utility.PasswordUtils;
import ua.mycompany.task4.domain.Department;
import ua.mycompany.task4.domain.Student;
import ua.mycompany.task4.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @After
    public void resetMock() {
        reset(studentRepository);
    }

    @Test
    public void shouldReturnRegisterStudent() {
        Student studentOldPassword = Student.builder().withPassword("1234").build();
        Student studentExpected = (Student) studentOldPassword.clone(PasswordUtils.generateSecurePassword(studentOldPassword.getPassword()));

        when(studentRepository.save(any(Student.class))).thenReturn(Optional.ofNullable(studentExpected));

        Optional<Student> studentActual = studentService.register(studentOldPassword);
        studentActual.ifPresent(student -> assertTrue(PasswordUtils.verifyUserPassword(studentOldPassword.getPassword(),studentActual.get().getPassword())));
        assertNotEquals("1234", studentActual.get().getPassword());
    }

    @Test
    public void shouldReturnLoginStudent() {
        Student studentOldPassword = Student.builder().withEmail("123@gmail.com").withPassword("1234").build();
        Student studentExpected = (Student) studentOldPassword.clone(PasswordUtils.generateSecurePassword(studentOldPassword.getPassword()));

        when(studentRepository.findByEmail(any(String.class))).thenReturn(Optional.ofNullable(studentExpected));

        Optional<Student> studentActual = studentService.login(studentOldPassword.getEmail(), studentOldPassword.getPassword());
        studentActual.ifPresent(student -> assertTrue(PasswordUtils.verifyUserPassword(studentOldPassword.getPassword(),studentActual.get().getPassword())));
        assertNotEquals("1234", studentActual.get().getPassword());
    }

    @Test
    public void shouldReturnStudentById() {
        Student studentExpected = Student.builder().build();
        when(studentRepository.findById(1L)).thenReturn(Optional.ofNullable(studentExpected));

        Optional<Student> studentActual = studentService.findById(1L);
        studentActual.ifPresent(student -> assertEquals(studentExpected, student));
    }

    @Test
    public void shouldReturnDeleteStudent() {
        Student studentExpected = Student.builder().build();
        when(studentRepository.deleteById(1L)).thenReturn(Optional.ofNullable(studentExpected));

        Optional<Student> studentActual = studentService.deleteById(1L);
        studentActual.ifPresent(student -> assertEquals(studentExpected, student));
    }

    @Test
    public void shouldReturnFindStudentsByDepartment() {
        Student studentExpected = Student.builder().withDepartment(new Department(228L, "KPI")).build();
        ArrayList<Student> studentsExpected = new ArrayList<>();
        studentsExpected.add(studentExpected);

        when(studentRepository.findByDepartment(228L)).thenReturn(studentsExpected);

        ArrayList<Student> studentsActual = studentService.findByDepartment(228L);
        assertArrayEquals(studentsExpected.toArray(), studentsActual.toArray());
    }

    @Test
    public void shouldReturnFindStudentsByYear() {
        Student studentExpected = Student.builder().withBirthday(LocalDate.of(1999, 1, 13)).build();
        ArrayList<Student> studentsExpected = new ArrayList<>();
        studentsExpected.add(studentExpected);

        when(studentRepository.findByYear(1991)).thenReturn(studentsExpected);

        ArrayList<Student> studentsActual = studentService.findByYear(1991);
        assertArrayEquals(studentsExpected.toArray(), studentsActual.toArray());
    }

    @Test
    public void shouldReturnFindStudentsByGroup() {
        Student studentExpected = Student.builder().withGroup("IP-62").build();
        ArrayList<Student> studentsExpected = new ArrayList<>();
        studentsExpected.add(studentExpected);

        when(studentRepository.findByGroup("IP-62")).thenReturn(studentsExpected);

        ArrayList<Student> studentsActual = studentService.findByGroup("IP-62");
        assertArrayEquals(studentsExpected.toArray(), studentsActual.toArray());
    }

    @Test
    public void shouldReturnFindStudentsByDepartmentAndCourse() {
        Student studentExpected = Student.builder().withDepartment(new Department(228L, "KPI")).withCourse(4).build();
        ArrayList<Student> studentsExpected = new ArrayList<>();
        studentsExpected.add(studentExpected);

        when(studentRepository.findByDepartmentAndCourse(228L, 4)).thenReturn(studentsExpected);

        ArrayList<Student> studentsActual = studentService.findByDepartmentAndCourse(228L, 4);
        assertArrayEquals(studentsExpected.toArray(), studentsActual.toArray());
    }

}
