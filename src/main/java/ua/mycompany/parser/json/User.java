package ua.mycompany.parser.json;

import java.util.List;
import java.util.Objects;

public class User {
    private final String name;
    private final String surname;
    private final int age;
    private final List<String> skills;

    public User(String name, String surname, int age, List<String> skills) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.skills = skills;
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

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(skills, user.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, skills);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
