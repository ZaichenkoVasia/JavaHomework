package ua.mycompany.task;

import ua.mycompany.task.entity.Student;
import ua.mycompany.task.init.StudentsInit;
import ua.mycompany.task.service.StudentServiceImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Student> students = StudentsInit.initStudents();
        List<Student> findingStudents;

        StudentServiceImpl studentServiceImpl = StudentServiceImpl.getInstance();

        findingStudents = studentServiceImpl.findByFaculty("FICT",students);
        studentServiceImpl.printFindingStudents("Students find by faculty FICT", findingStudents);

        findingStudents = studentServiceImpl.findByYear(1990,students);
        studentServiceImpl.printFindingStudents("Students find by year more 1990", findingStudents);

        findingStudents = studentServiceImpl.findByGroup("IP-64",students);
        studentServiceImpl.printFindingStudents("Students find by group IP-64", findingStudents);

        findingStudents = studentServiceImpl.findByFacultyAndCourse("FICT",4,students);
        studentServiceImpl.printFindingStudents("Students find by faculty FICT and course 4", findingStudents);
    }
}
