package ua.mycompany.task4.domain;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final Long id;
    private final String name;
    private final String surname;
    private final LocalDate birthday;
    private final Address address;
    private final Department department;
    private final String phoneNumber;
    private final String group;
    private final int course;
    private final String email;
    private static Long counter = 0L;

    private final Comparator<Student> STUDENT_COMPARATOR_BY_AGE =
            Comparator.comparingInt(student -> LocalDate.now().getYear() - student.birthday.getYear());

    private final Comparator<Student> STUDENT_COMPARATOR_BY_NAME =
            Comparator.comparing(student -> student.name);

    private final Comparator<Student> STUDENT_COMPARATOR_BY_SURNAME =
            Comparator.comparing(student -> student.surname);

    private Student(Builder builder) {
        this.id = ++counter;
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthday = builder.birthday;
        this.address = builder.address;
        this.department = builder.department;
        this.phoneNumber = builder.phoneNumber;
        this.group = builder.group;
        this.course = builder.course;
        this.email = builder.email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Comparator<Student> getUserComparator() {
        return STUDENT_COMPARATOR_BY_NAME.thenComparing(STUDENT_COMPARATOR_BY_SURNAME.thenComparing(STUDENT_COMPARATOR_BY_AGE));
    }

    @Override
    public int compareTo(Student o) {
        return this.getUserComparator().compare(this, o);
    }

    public static class Builder {
        private String name;
        private String surname;
        private LocalDate birthday;
        private Address address;
        private Department department;
        private String phoneNumber;
        private String group;
        private int course;
        private String email;

        private Builder() {
        }

        public Student build() {
            return new Student(this);
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withDepartment(Department department) {
            this.department = department;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder withCourse(int course) {
            this.course = course;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(birthday, student.birthday) &&
                Objects.equals(address, student.address) &&
                Objects.equals(department, student.department) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(group, student.group) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, address, department, phoneNumber, group, course, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                ", department=" + department +
                ", phoneNumber=" + phoneNumber +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", email='" + email + '\'' +
                '}';
    }
}
