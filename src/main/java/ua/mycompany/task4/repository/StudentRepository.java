package ua.mycompany.task4.repository;

import ua.mycompany.task4.domain.Student;

import java.util.ArrayList;

public interface StudentRepository {

    Student save(Student student);

    Student findByEmail(String email);

    Student findById(Long id);

    void update(Student student);

    Student deleteById(Long id);

    ArrayList<Student> findByDepartment(Long idDepartment);

    ArrayList<Student> findByYear(int year);

    ArrayList<Student> findByGroup(String group);

    ArrayList<Student> findByDepartmentAndCourse(Long idDepartment, int course);

    ArrayList<Student> findAll();
}
