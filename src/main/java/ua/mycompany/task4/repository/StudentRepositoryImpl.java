package ua.mycompany.task4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.mycompany.task4.domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private Map<Long, Student> idToStudents = new HashMap<>();
    private static Long counter = 0L;

    @Autowired
    public StudentRepositoryImpl() {
    }

    @Override
    public Student save(Student student) {
        return idToStudents.put(++counter, student);
    }

    @Override
    public Student findByEmail(String email) {
        Student student = null;
        for (Long i = 1L; i < idToStudents.size() + 1; i++) {
            if (idToStudents.get(i).getEmail().equals(email)) {
                student = idToStudents.get(i);
                break;
            }
        }
        return student;
    }

    @Override
    public Student findById(Long id) {
        return idToStudents.get(id);
    }

    @Override
    public void update(Student student) {
        idToStudents.replace(student.getId(), student);
    }

    @Override
    public Student deleteById(Long id) {
        return idToStudents.remove(id);
    }

    @Override
    public ArrayList<Student> findByDepartment(Long idDepartment) {
        ArrayList<Student> findByDepartmentStudents = new ArrayList<>();
        for (Long i = 1L; i < idToStudents.size()+1; i++) {
            if (idDepartment.equals(idToStudents.get(i).getDepartment().getId())) {
                findByDepartmentStudents.add(idToStudents.get(i));
            }
        }
        return findByDepartmentStudents;
    }

    @Override
    public ArrayList<Student> findByYear(int year) {
        ArrayList<Student> findByYearStudents = new ArrayList<>();

        for (Long i = 1L; i < idToStudents.size()+1; i++) {
            if (year < idToStudents.get(i).getBirthday().getYear()) {
                findByYearStudents.add(idToStudents.get(i));
            }
        }
        return findByYearStudents;
    }

    @Override
    public ArrayList<Student> findByGroup(String group) {
        ArrayList<Student> findByGroupStudents = new ArrayList<>();
        for (Long i = 1L; i < idToStudents.size()+1; i++) {
            if (group.equals(idToStudents.get(i).getGroup())) {
                findByGroupStudents.add(idToStudents.get(i));
            }
        }
        return findByGroupStudents;
    }

    @Override
    public ArrayList<Student> findByDepartmentAndCourse(Long idDepartment, int course) {
        ArrayList<Student> findByDepartmentAndCourseStudents = new ArrayList<>();
        for (Long i = 1L; i < idToStudents.size()+1; i++) {
            if (idDepartment.equals(idToStudents.get(i).getDepartment().getId())
                    && course == idToStudents.get(i).getCourse()) {
                findByDepartmentAndCourseStudents.add(idToStudents.get(i));
            }
        }
        return findByDepartmentAndCourseStudents;
    }

    @Override
    public ArrayList<Student> findAll() {
        return new ArrayList<Student> (idToStudents.values());
    }
}