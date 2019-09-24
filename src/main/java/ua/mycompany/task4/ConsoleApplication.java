package ua.mycompany.task4;

import ua.mycompany.task4.init.Menu;
import ua.mycompany.task4.view.StudentViewInfo;

public class ConsoleApplication {
    public static void main(String[] args) {
        new Menu().run();
        new StudentViewInfo().run();
    }
}
