package classes;

import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Classes {
    public static void main(String[] args) {
        //Define students
        Student student1 = new Student("Andrei", "Negoita", 2231, 10);
        Student student2 = new Student("Ion", "Mateescu", 4221, 7);
        Student student3 = new Student("Stefan", "Stefanescu", 4562, 9);
        Student student4 = new Student("Filip", "Marian", 4622, 8);
        Student student5 = new Student("Florin", "Matei", 2221, 10);
        Student student6 = new Student("Matei", "Serban", 4221, 9);
        Student student7 = new Student("Paul", "Floroiu", 3224, 5);
        Student student8 = new Student("Alexandru", "Ivan", 4221, 10);
        Student student9 = new Student("Lucian", "Rusu", 3224,7);

        //Create set of students
        Set<Student> MR_students = new TreeSet<>();
        Set<Student> SS_students = new TreeSet<>();
        Set<Student> ED_students = new TreeSet<>();
        Set<Student> AT_students = new TreeSet<>();
        //TreeSet<>() enables sorting according to the natural ordering of its elements as defined
        //in the compareTo() method in the Student class

        //Add students in sets
        MR_students.add(student1);
        MR_students.add(student2);
        MR_students.add(student6);
        MR_students.add(student7);
        SS_students.add(student4);
        SS_students.add(student5);
        ED_students.add(student3);
        ED_students.add(student1);
        AT_students.add(student8);
        AT_students.add(student9);

        //Define Professor
        Professor prof = new Professor("Anton", "Panaitescu");
        Professor default_prof = new Professor();
        Professor profAT = new Professor("Mihai", "Antonescu");

        //Define new course
        Course course = new Course("Material Resistance", "Calculations of reactions,\n"
                + "effort diagrams, calculations of geometric characteristics of\n" +
                "flat surfaces and calculations of resistance elements to simple stresses\n",
                prof, MR_students, 0);
        Course sscourse = new Course("Signals and Systems I", "Processing and analysis of signals",
                prof, SS_students, 0);
        Course default_course = new Course();
        Course courseED = new Course("Electronic Devices", "Study of electronic devices", prof, ED_students, 0);
        Course courseAT = new Course("Antennae", "Study of antennae",profAT,AT_students, 0 );

        //Add course to the list of courses
        CourseManager courseManager = new CourseManager();
        courseManager.AddCourse(course);
        courseManager.AddCourse(sscourse);
        courseManager.AddCourse(default_course);
        courseManager.AddCourse(courseAT);

        //List courses in alphabetical order
        courseManager.sortCoursesByName();

        //Remove course from the list of courses
        courseManager.DeleteCourse(default_course);

        //Update course from list of courses (remove comment to test)
        //courseManager.UpdateCourse(courseED);

        //Enroll a student in a course
        courseManager.enrollStudent("Material Resistance", student3);

        //Dismiss a student from a course
        courseManager.dismissStudent("Material Resistance", student3);

        //Update a student from a course
        sscourse.UpdateStudent(student3);

        //Update a course professor
        sscourse.UpdateProfessor(default_prof);

        //Update a course name and description (remove comment to test)
       /* sscourse.UpdateCourse("Advanced Mathematics", "Complex numbers," +
                " diferential equations, Laplace and Fourier series"); */

        //Display courses to the console
        courseManager.displayCoursesToConsole();

        //Display student full name
        System.out.println(student1.getFullName());

        //Display teacher full name
        System.out.println(prof.getFullName());
        System.out.println(default_prof.getFullName());


        //List students in a course
        courseManager.listStudentsInCourse("Material Resistance");
        courseManager.listStudentsInCourse("Signals and Systems I");

        //Average course grade
        courseManager.returnAverageCourseGrade("Material Resistance");
        courseManager.returnAverageCourseGrade("Signals and Systems I");
        courseManager.returnAverageCourseGrade("Advanced Mathematics");
        courseManager.returnAverageCourseGrade("Electronic Devices");
        courseManager.returnAverageProfGrade("Anton Panaitescu");

        //Grouping all enrolled students by their respective Group Numbers
        courseManager.groupStudentsByGN();

        //Search for course
        courseManager.findCourse("Material Resistance");
    }
}
