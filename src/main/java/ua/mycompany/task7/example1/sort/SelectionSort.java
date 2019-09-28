package ua.mycompany.task7.example1.sort;

import ua.mycompany.task7.example1.User;

import java.util.ArrayList;

public final class SelectionSort {

    private SelectionSort() {

    }

    public static void sort(ArrayList<User> users) {

        for (int left = 0; left < users.size(); left++) {
            int minInd = left;
            for (int i = left; i < users.size(); i++) {
                if (users.get(i).compareTo(users.get(minInd)) < 0) {
                    minInd = i;
                }
            }
            Utility.swap(users, left, minInd);
        }
    }
}
