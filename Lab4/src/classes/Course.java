package classes;

import java.util.Set;
import java.util.HashSet;

public class Course implements CourseOperations, Comparable<Course> {
    String name;
    String description;
    Professor teacher;
    Set<Student> students;
    float averageGrade;

    public Course() {
        this.name = " ";
        this.description = " ";
        this.teacher = new Professor();
        this.students = new HashSet<>();
        this.averageGrade = 0.0f;
    }
    //default constructor

    public Course(String name, String description, Professor teacher, Set<Student> students, float averageGrade) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = students;
    }

    @Override
    public String toString() {
        String str = "Course: " + "name=" + name + ", description=" +
                description + ",\nTeacher=" + teacher + ",\nStudents:\n";
        for (Student s : students) {
            str += s + "\n";
        }
        return str;
    }

    @Override
    public void UpdateProfessor(Professor p) {
        this.teacher = p;
    }

    @Override
    public void AddStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public void RemoveStudent(Student student) {
        this.students.remove(student);
    }

    @Override
    public void UpdateStudent(Student student) {
        Student update = null;
        for (Student s : students) {
            if (s.grade < student.grade) {
                update = s;
                break;
            }
        }
        if (update != null) {
            students.remove(update);
            students.add(student);
        }
    }

    @Override
    public void UpdateCourse(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int compareTo(Course other_course) {
        return this.name.compareTo(other_course.name);
    }
}
