package ua.mycompany.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mycompany.task4.domain.Student;
import ua.mycompany.task4.service.StudentService;

import java.util.ArrayList;

@Component
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

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

    public ArrayList<Student> findAll() {
        return studentService.findAll();
    }
}
