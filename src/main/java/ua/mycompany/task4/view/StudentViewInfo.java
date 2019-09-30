package ua.mycompany.task4.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mycompany.task4.Helper.Localization.UTF8Control;
import ua.mycompany.task4.Helper.Validator.ValidatorFactory;
import ua.mycompany.task4.Helper.sort.BubbleSort;
import ua.mycompany.task4.controller.StudentController;
import ua.mycompany.task4.domain.Department;
import ua.mycompany.task4.domain.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@Component
public class StudentViewInfo {

    private StudentController studentController;
    private ResourceBundle lang;
    private Scanner in = new Scanner(System.in);

    @Autowired
    public StudentViewInfo(StudentController studentController) {
        this.studentController = studentController;
    }

    public void run() {
        chooseMenuLang();
    }

    private void chooseMenuLang() {

        System.out.println("Choose language/Оберіть мову");
        System.out.println("English (1)");
        System.out.println("Українська (2)");
        int chooseLanguage = in.nextInt();

        chooseLang(chooseLanguage);
    }

    private void chooseLang(int chooseLanguage) {

        try {
            if (chooseLanguage == 1) {
                lang = ResourceBundle.getBundle("resources", new Locale("en"), new UTF8Control());
            } else if (chooseLanguage == 2) {
                lang = ResourceBundle.getBundle("resources", new Locale("ua"), new UTF8Control());
            } else
                chooseMenuLang();
        } catch (Exception e) {
            throw new IllegalArgumentException(lang.getString("uncorrectedArgument"));
        }
        menu();
    }

    private void menu() {

        System.out.println(lang.getString("menu"));
        System.out.println("1 - " + lang.getString("viewStudent"));
        System.out.println("2 - " + lang.getString("addStudent"));
        System.out.println("3 - " + lang.getString("sortStudent"));
        System.out.println("4 - " + lang.getString("chooseLanguage"));
        System.out.println("5 - " + lang.getString("inputId"));
        System.out.println("6 - " + lang.getString("inputDepartment"));
        System.out.println("7 - " + lang.getString("inputGroup"));
        System.out.println("8 - " + lang.getString("inputCourse"));

        int choice;
        try {
            choice = in.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(lang.getString("uncorrectedArgument"));
        }

        switch (choice) {
            case 1:
                printAllUsers(studentController.findAll());
                break;
            case 2:
                createUserFromConsole();
                break;
            case 3:
                sortUser();
                break;
            case 4:
                chooseMenuLang();
                break;
            case 5:
                System.out.println(findById());
                break;
            case 6:
                printAllUsers(findByDepartment());
                break;
            case 7:
                printAllUsers(findByGroup());
                break;
            case 8:
                printAllUsers(findByDepartmentAndCourse());
                break;
        }
        menu();
    }

    private void printAllUsers(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println(lang.getString("noStudentYet"));
        } else {
            System.out.println("\n" + lang.getString("listStudent"));
            for (Student student : students
            ) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    private void createUserFromConsole() {

        String name = writeFieldValidator("name");
        String surname = writeFieldValidator("surname");
        String email = writeFieldValidator("email");
        String phoneNumber = writeFieldValidator("phoneNumber");
        String birthday = writeFieldValidator("date");
        Department department = new Department(1L, "dep1");
        System.out.println(lang.getString("groupStudent"));
        String group = in.nextLine();
        int course = Integer.parseInt(writeFieldValidator("course"));

        Student student = Student.builder()
                .withName(name)
                .withSurname(surname)
                .withBirthday(splitBirthday(birthday))
                .withDepartment(department)
                .withPhoneNumber(phoneNumber)
                .withGroup(group)
                .withCourse(course)
                .withEmail(email)
                .build();
        studentController.register(student);
        System.out.println(lang.getString("studentCreated") + "\n");

        menu();
    }

    private LocalDate splitBirthday(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(birthday, formatter);
    }

    private void sortUser() {
        System.out.println(lang.getString("usersAreSorted") + "\n");
        printAllUsers(BubbleSort.sort(studentController.findAll()));
    }

    private String writeFieldValidator(String nameField) {

        String key = nameField + "Student";
        System.out.println(lang.getString(key));
        String fieldInput = in.nextLine();
        if (!ValidatorFactory.getValidator(nameField).validate(fieldInput)) {
            System.out.println(lang.getString("uncorrectedValue"));
            fieldInput = writeFieldValidator(nameField);
        }
        return fieldInput;
    }

    private Student findById(){
        System.out.println(lang.getString("inputId"));
        return studentController.findById(in.nextLong());
    }

    private ArrayList<Student> findByDepartment(){
        System.out.println(lang.getString("inputDepartment"));
        return studentController.findByDepartment(in.nextLong());
    }

    private ArrayList<Student> findByGroup(){
        System.out.println(lang.getString("inputGroup"));
        String group = in.nextLine();
        group = in.nextLine();
        return studentController.findByGroup(group);
    }

    private ArrayList<Student> findByDepartmentAndCourse(){
        System.out.println(lang.getString("inputDepartment"));
        Long idDepartment = in.nextLong();
        System.out.println(lang.getString("inputCourse"));
        int course = in.nextInt();
        return studentController.findByDepartmentAndCourse(idDepartment, course);
    }

}
