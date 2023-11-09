package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CourseManager implements ManagerCourseOperations {
    List<Course> courses;
    Map<Integer, Set<Student>> groupMap;

    public CourseManager() {
        courses = new ArrayList<>();
        groupMap = new HashMap<>();
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
                course.averageGrade /= course.students.size();
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

    public void groupStudentsByGN() {
        System.out.println(" "); //for better readability
        groupMap.clear(); //clears existing maps for further use in different cases
        int groupNumber = 0;
        for (Course course : courses) {
            for (Student student : course.students) {
                groupNumber = student.getGroupNumber();
                if (!groupMap.containsKey(groupNumber)) { //check if map contains entry for group number
                    groupMap.put(groupNumber, new HashSet<>());
                }

                groupMap.get(groupNumber).add(student); //add student to their corresponding group
            }
        }
        //displaying groups
        for (Map.Entry<Integer, Set<Student>> entry : groupMap.entrySet()) { //iterates over each entry in the map
            System.out.println("Group " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.println("- " + student.getFullName());
            }
            System.out.println();
        }
    }

    public void sortCoursesByName() {
        Collections.sort(courses);
    }
    //This method enables sorting according to the natural ordering of its elements as defined
    //in the compareTo() method in the Course class

    public void findCourse(String courseName) {
        for (Course course : courses) {
            if (course.name.equals(courseName)) {
                System.out.println(course);
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }
    //This method iterates through all existing courses in our list, if a course name
    //matches our courseName string, the course with all its attributes is displayed and the method
    //ends, if no matching course is found we display a "Course not found" message

    @Override
    public void AddCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void UpdateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (Objects.equals(courses.get(i).teacher.getProf(), course.teacher.getProf())) {
                courses.set(i, course);
                return;
            }
        }
    }

    @Override
    public void DeleteCourse(Course course) {
        courses.remove(course);
    }
}
