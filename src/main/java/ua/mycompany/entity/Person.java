package ua.mycompany.entity;

import java.time.LocalDate;

public class Person {
    private final int id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final LocalDate birthday;


    public Person(PersonBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.patronymic = builder.patronymic;
        this.birthday = builder.birthday;
    }

    public Person(Person person) {
        this.id = person.id;
        this.name = person.name;
        this.surname = person.surname;
        this.patronymic = person.patronymic;
        this.birthday = person.birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public static class PersonBuilder {
        private int id;
        private String name;
        private String surname;
        private String patronymic;
        private LocalDate birthday;

        public PersonBuilder withId(int id) {
            if (id < 0) {
                throw new IllegalArgumentException("Id must be positive");
            }

            this.id = id;
            return this;
        }

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder withPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public PersonBuilder withBirthday(LocalDate birthday) {
            if (birthday.getYear() < 1900 || birthday.getYear() > LocalDate.now().getYear()) {
                throw new IllegalArgumentException("Year is not correct");
            }

            this.birthday = birthday;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
