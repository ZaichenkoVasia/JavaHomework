package ua.mycompany.task4.view;

import ua.mycompany.task4.controller.StudentController;
import ua.mycompany.task4.domain.Student;
import java.util.ArrayList;

public class StudentViewInfo {
    StudentController studentController = new StudentController();
    public void run() {
        System.out.println("Id");
        print(studentController.findById(1L));
        System.out.println("Dep");
        print(studentController.findByDepartment(1L));
        System.out.println("Group");
        print(studentController.findByGroup("AA-11"));
        System.out.println("Dep+course");
        print(studentController.findByDepartmentAndCourse(1L, 4));
    }

    private void print(ArrayList<Student> students) {
        for (Student student : students
        ) {
            print(student);
        }
    }

    private void print(Student student) {
        System.out.println(student);
    }

}
