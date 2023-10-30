package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class CourseManager implements ManagerCourseOperations {
    Course[] courses;

    public CourseManager() {
        Connection conn = null;
        courses = new Course[0];
    }

    public void displayCoursesToConsole() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public void enrollStudent(String courseName, Student student) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                course.AddStudent(student);
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }

    public void dismissStudent(String courseName, Student student) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                course.RemoveStudent(student);
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }
    //test method for the RemoveStudent interface

    public void listStudentsInCourse(String courseName) {
        System.out.println("\n--Students enrolled in " + courseName + " course:");
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                for (Student student : course.students) {
                    System.out.println(student.getFullName() + " ");
                }
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }

    public void returnAverageCourseGrade(String courseName) {
        System.out.println("\n--" + courseName + " average grade is: ");
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                for (Student student : course.students) {
                    course.averageGrade += student.grade;
                }
                course.averageGrade /= course.students.length;
                System.out.printf("%.1f", course.averageGrade); //print float value with only one decimal
                System.out.println(" "); //newline for easier readability
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }

    public void returnAverageProfGrade(String profName) {
        System.out.println("\n--Average grade given by " + profName + ": ");
        float totalGrade = 0f;
        int ctr = 0;
        for (Course course : courses) {
            if (course.teacher.getProf().equals(profName)) {
                System.out.println("Prof " + profName + " found in course: " + course.name);
                totalGrade += course.averageGrade;
                ctr++;
            } else {
                System.out.println("Prof " + profName + " not found in course: " + course.name);
            }
        }
        if (totalGrade == 0) {
            return;
        }
        System.out.println("Calculating average professor grade: ");
        System.out.printf("%.1f", totalGrade / ctr);
        System.out.println(" "); //newline
    }

    @Override
    public void AddCourse(Course course) {
        int newLength = courses.length + 1;
        Course[] aux = new Course[newLength];
        int index = 0;
        for (Course c : courses) {
            aux[index++] = c;
        }
        //Finally, we add the new course at the last index
        aux[index] = course;
        //And we reallocate the courses list with aux
        this.courses = new Course[newLength];
        System.arraycopy(aux, 0, courses, 0, newLength);
    }

    @Override
    public void UpdateCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (Objects.equals(courses[i].teacher.getProf(), course.teacher.getProf())) {
                courses[i].name = course.name;
                courses[i].description = course.description;
                courses[i].teacher = course.teacher;
                courses[i].students = course.students;
                courses[i].averageGrade = course.averageGrade;
                return;
            }
        }
    }
    /* this method checks course teacher names, first course with a matching name will be
    replaced by our selected course */

    @Override
    public void DeleteCourse(Course course) {
        int indexToRemove = -1;

        //Find the index of the course to remove
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].equals(course)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            //Create a new array with length - 1
            Course[] newCourses = new Course[courses.length - 1];

            //Copy courses before the removed course
            if (indexToRemove > 0) {
                System.arraycopy(courses, 0, newCourses, 0, indexToRemove);
            }

            //Copy courses after the removed course
            if (indexToRemove < courses.length - 1) {
                System.arraycopy(courses, indexToRemove + 1, newCourses, indexToRemove, courses.length - indexToRemove - 1);
            }

            //Assign the new array back to the 'courses' field
            courses = newCourses;
        }
    }
}
