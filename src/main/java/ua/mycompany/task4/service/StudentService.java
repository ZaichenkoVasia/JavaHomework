package ua.mycompany.task4.service;

import ua.mycompany.task4.domain.Student;

import java.util.ArrayList;
import java.util.Optional;

public interface StudentService {

    Optional<Student> register(Student student);

    Optional<Student> login (String email, String password);

    Optional<Student> findById(Long id);

    void update(Student student);

    Optional<Student> deleteById(Long id);

    ArrayList<Student> findByDepartment(Long idDepartment);

    ArrayList<Student> findByYear(int year);

    ArrayList<Student> findByGroup(String group);

    ArrayList<Student> findByDepartmentAndCourse(Long idDepartment, int course);

    ArrayList<Student> findAll ();
}
