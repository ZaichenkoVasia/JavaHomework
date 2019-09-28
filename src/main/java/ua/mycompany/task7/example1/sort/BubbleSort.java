package ua.mycompany.task7.example1.sort;

import ua.mycompany.task7.example1.User;

import java.util.ArrayList;

public final class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(ArrayList<User> users) {

        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                if (users.get(j).compareTo(users.get(j + 1)) > 0)
                    Utility.swap(users, j, j + 1);
            }
        }
    }
}
