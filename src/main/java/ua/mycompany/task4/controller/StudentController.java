package ua.mycompany.task4.controller;

import ua.mycompany.task4.domain.Student;
import ua.mycompany.task4.repository.StudentRepositoryImpl;
import ua.mycompany.task4.service.StudentService;
import ua.mycompany.task4.service.StudentServiceImpl;
import ua.mycompany.task4.repository.StudentRepository;

import java.util.ArrayList;

public class StudentController {
    private StudentRepository studentRepository = StudentRepositoryImpl.getInstance();
    private StudentService studentService = StudentServiceImpl.getInstance(studentRepository);

    public Student register(Student student) {
        return studentService.register(student);
    }

    public Student findById(Long id) {
        return studentService.findById(id);
    }

    public void update(Student student) {
        studentService.update(student);
    }

    public Student deleteById(Long id) {
        return studentService.deleteById(id);
    }

    public ArrayList<Student> findByDepartment(Long idDepartment) {
        return studentService.findByDepartment(idDepartment);
    }

    public ArrayList<Student> findByYear(int year) {
        return studentService.findByYear(year);
    }

    public ArrayList<Student> findByGroup(String group) {
        return studentService.findByGroup(group);
    }

    public ArrayList<Student> findByDepartmentAndCourse(Long idDepartment, int course) {
        return studentService.findByDepartmentAndCourse(idDepartment, course);
    }
}
