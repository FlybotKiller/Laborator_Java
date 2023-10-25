package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseManager {
    Course[] courses;

    public CourseManager() {
        Connection conn = null;
        courses = new Course[0];
    }

    public void addCourse(Course course) {
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

    public void displayCoursesToConsole() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public void enrollStudent(String courseName, Student student) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                course.addStudent(student);
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }
    /* Ex 2: This method iterates through each course, checking for course names
    that are equal to the courseName string, if none are found it displays
    a "course not found" message alongside the string we introduced.
     If a course with a matching name is found, we use the .addStudent() method
     to enroll a student in that course. */

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
    /* Ex 3: By using the enrollStudent method as reference, this method compares the courseName string
    with existing course names, if names match, with each iteration,
     every student assigned in said course is displayed using the .getFullName() method. */

    public void returnAverageCourseGrade(String courseName) {
        System.out.println("\n--" + courseName + " average grade is: ");
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                for (Student student : course.students) {
                    course.averageGrade += student.grade;
                }
                course.averageGrade /= course.students.length;
                System.out.printf("%.1f", course.averageGrade); //print float value with only one decimal
                System.out.println(" "); //newline
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }
    /* Ex 4: .returnAverageCourseGrade() checks if our string courseName is similar to any existing courses,
    it then browses our existing enrolled students and with each iteration updates our averageGrade
    value by adding each student's grade, after finishing all iterations we display the average grade
    after dividing averageGrade's value by the length of our students array, thus making it easier
    for further use in case new students will be enrolled. */

    public void returnAverageProfGrade(String profName) {
        System.out.println("\n--Average grade given by " + profName + ": ");
        float totalGrade = 0f;
        for (Course course : courses) {
            if (course.teacher.getProf().equals(profName)) {
                System.out.println("Prof " + profName + " found in course: " + course.name);
                totalGrade += course.averageGrade;
            } else {
                System.out.println("Prof " + profName + " not found in course: " + course.name);
            }

        }
        if (totalGrade == 0) {
            return;
        }
        System.out.println("Calculating average professor grade: ");
        System.out.printf("%.1f", totalGrade / courses.length);
        System.out.println(" "); //newline
    }
    /* Ex 5: this method iterates through each course, comparing existing professor names with our
    profName string, if names match, we list the courses containing the prof object,
    add each averageGrade object and store the value in totalGrade.
    If no names match, totalGrade value will be 0 by default, if totalGrade is 0,
    we use return to end the method earlier
    To return the average professor grade, we divide totalGrade by the length of the course array,
    thus making it easier for further use in case new courses are added which contain the same
    professor object.
    "%.1f" is used to return the value as float, with only one decimal
     We assume that each course has different students enrolled for this method to be optimal. */
}

