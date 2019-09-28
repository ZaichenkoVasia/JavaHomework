package ua.mycompany.task4.service;

import ua.mycompany.task4.domain.Student;
import ua.mycompany.task4.repository.StudentRepository;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private static StudentServiceImpl studentService;

    private StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static StudentService getInstance(StudentRepository studentRepository) {
        if (studentService == null) {
            studentService = new StudentServiceImpl(studentRepository);
        }

        return studentService;
    }

    @Override
    public Student register(Student student) {
        if (student == null) {
            throw new IllegalArgumentException(" Student is null");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("id must be > 0");
        }
        return studentRepository.findById(id);
    }

    @Override
    public void update(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("");
        }
        studentRepository.update(student);
    }

    @Override
    public Student deleteById(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("id must be > 0");
        }
        return studentRepository.deleteById(id);
    }

    @Override
    public ArrayList<Student> findByDepartment(Long idDepartment) {
        if (idDepartment < 0) {
            throw new IllegalArgumentException("id must be > 0");
        }
        return studentRepository.findByDepartment(idDepartment);
    }

    @Override
    public ArrayList<Student> findByYear(int year) {
        if (year < 1990) {
            throw new IllegalArgumentException("year must be > 1990");
        }
        return studentRepository.findByYear(year);
    }

    @Override
    public ArrayList<Student> findByGroup(String group) {
        if (group == null) {
            throw new IllegalArgumentException("Group can not be null");
        }
        return studentRepository.findByGroup(group);
    }

    @Override
    public ArrayList<Student> findByDepartmentAndCourse(Long idDepartment, int course) {
        if (course < 0 || course > 6 || idDepartment < 0) {
            throw new IllegalArgumentException("Course must be in range [0;6] or id department must be positive");
        }
        return studentRepository.findByDepartmentAndCourse(idDepartment, course);
    }

    @Override
    public ArrayList<Student> findAll() {
        return studentRepository.findAll();
    }

}
