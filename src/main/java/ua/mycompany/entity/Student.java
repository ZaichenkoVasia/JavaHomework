package homework.homework4.entity;

import java.time.LocalDate;

public class Student extends Person {
    private String address;
    private String tel;
    private String faculty;
    private int course;
    private String group;

    public Student(StudentBuilder builder, Person person) {
        super(person);
        this.address = builder.address;
        this.tel = builder.tel;
        this.faculty = builder.faculty;
        this.course = builder.course;
        this.group = builder.group;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                ", " + super.toString() +
                '}';
    }

    public static class StudentBuilder {
        private String address;
        private String tel;
        private String faculty;
        private int course;
        private String group;

        public StudentBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder withTel(String tel) {
            this.tel = tel;
            return this;
        }

        public StudentBuilder withFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public StudentBuilder withCourse(int course) {
            if(course<0 || course>6)
                throw new IllegalArgumentException("Course in diapason [0;6]");

            this.course = course;
            return this;
        }

        public StudentBuilder withGroup(String group) {
            this.group = group;
            return this;
        }


        public Student build(Person person) {
            return new Student(this, person);
        }
    }
}
