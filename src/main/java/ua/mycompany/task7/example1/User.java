package ua.mycompany.task7.example1;

import java.util.Comparator;

public class User implements Comparable<User>{
    private final Comparator<User> USER_COMPARATOR_BY_AGE =
            Comparator.comparingInt(user -> user.age);

    private final Comparator<User> USER_COMPARATOR_BY_NAME =
            Comparator.comparing(user -> user.name);

    private final Comparator<User> USER_COMPARATOR_BY_SURNAME =
            Comparator.comparing(user -> user.surname);

    private String name;
    private String surname;
    private int age;
    private String email;

    public User(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public Comparator<User> getUserComparator() {
        return USER_COMPARATOR_BY_NAME.thenComparing(USER_COMPARATOR_BY_SURNAME.thenComparing(USER_COMPARATOR_BY_AGE));
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public int compareTo(User o) {
        return this.getUserComparator().compare(this, o);
    }
}
