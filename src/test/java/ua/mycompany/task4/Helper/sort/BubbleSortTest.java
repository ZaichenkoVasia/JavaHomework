package ua.mycompany.task4.Helper.sort;

import org.junit.Assert;
import org.junit.Test;
import ua.mycompany.task4.domain.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class BubbleSortTest {

    @Test
    public void shouldReturnSortArrayList() {
        Student student1 = Student.builder().withName("dima").withSurname("petrenko").withBirthday(LocalDate.of(1999, 12, 1)).build();
        Student student2 = Student.builder().withName("anton").withSurname("vadimenko").withBirthday(LocalDate.of(1999, 12, 1)).build();
        Student student3 = Student.builder().withName("anton").withSurname("antonenko").withBirthday(LocalDate.of(1999, 12, 1)).build();

        ArrayList studentsExpected = new ArrayList();
        studentsExpected.add(student3);
        studentsExpected.add(student2);
        studentsExpected.add(student1);

        ArrayList studentsActual = new ArrayList();
        studentsActual.add(student1);
        studentsActual.add(student2);
        studentsActual.add(student3);
        BubbleSort.sort(studentsActual);

        Assert.assertArrayEquals(studentsExpected.toArray(), studentsActual.toArray());
    }
}
