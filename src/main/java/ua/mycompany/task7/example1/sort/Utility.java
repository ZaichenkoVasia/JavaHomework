package ua.mycompany.task7.example1.sort;


import ua.mycompany.task7.example1.User;

import java.util.ArrayList;
import java.util.Collections;

final class Utility {
    private Utility() {
    }

    public static void swap(ArrayList<User> users, int i, int j) {
        Collections.swap(users, i, j);
    }
}
