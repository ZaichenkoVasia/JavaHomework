package ua.mycompany.task4.Helper.sort;

import ua.mycompany.task4.domain.Student;

import java.util.ArrayList;

public final class SelectionSort {

    private SelectionSort() {

    }

    public static ArrayList<Student> sort(ArrayList<Student> students) {

        for (int left = 0; left < students.size(); left++) {
            int minInd = left;
            for (int i = left; i < students.size(); i++) {
                if (students.get(i).compareTo(students.get(minInd)) < 0) {
                    minInd = i;
                }
            }
            Utility.swap(students, left, minInd);
        }
        return students;
    }
}
