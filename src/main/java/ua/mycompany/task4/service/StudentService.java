package ua.mycompany.task4.service;

import ua.mycompany.task4.domain.Student;

import java.util.ArrayList;

public interface StudentService {

    Student register(Student student);

    Student findById(Long id);

    void update(Student student);

    Student deleteById(Long id);

    ArrayList<Student> findByDepartment(Long idDepartment);

    ArrayList<Student> findByYear(int year);

    ArrayList<Student> findByGroup(String group);

    ArrayList<Student> findByDepartmentAndCourse(Long idDepartment, int cource);
}
