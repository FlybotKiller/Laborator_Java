package classes;

public class Classes {
    public static void main(String[] args) {
        //Define students
        Student[] students = new Student[]{new Student("Andrei", "Negoita",
                2231, 10), new Student("Ion", "Mateescu", 4221, 7)};
        Student stud = new Student("Stefan", "Stefanescu", 4562, 9);
        Student[] signals = new Student[]{new Student("Filip", "Marian",
                4622, 8), new Student("Florin", "Matei", 2221, 10)};
        /*Student[] studED = new Student[]{new Student("Mihai", "Floroiu",
                4532, 6), new Student("Ion", "Ivanovici", 4221, 5)}; */

        //Define Professor
        Professor prof = new Professor("Anton", "Panaitescu");
        Professor default_prof = new Professor();

        //Define new course
        Course course = new Course("Material Resistance", "Calculations of reactions,\n"
                + "effort diagrams, calculations of geometric characteristics of\n" +
                "flat surfaces and calculations of resistance elements to simple stresses\n",
                prof, students, 0);
        Course sscourse = new Course("Signals and Systems I", "Processing and analysis of signals",
                prof, signals, 0);
        Course default_course = new Course();
        //Course courseED = new Course("Electronic Devices", "Study of electronic devices", default_prof, studED, 0);

        //Add course to the list of courses
        CourseManager courseManager = new CourseManager();
        courseManager.AddCourse(course);
        courseManager.AddCourse(sscourse);
        courseManager.AddCourse(default_course);
        //courseManager.AddCourse(courseED);

        //Remove course from the list of courses
        courseManager.DeleteCourse(default_course);

        //Update course from list of courses (remove comment to test)
       // courseManager.UpdateCourse(sscourse);

        //Enroll a student in a course
        courseManager.enrollStudent("Material Resistance", stud);

        //Dismiss a student from a course
        courseManager.dismissStudent("Material Resistance", stud);

        //Update a student from a course
        sscourse.UpdateStudent(stud);

        //Update a course professor
        sscourse.UpdateProfessor(default_prof);

        //Update a course name and description
        sscourse.UpdateCourse("Advanced Mathematics", "Complex numbers," +
                " diferential equations, Laplace and Fourier series");

        //Display courses to the console
        courseManager.displayCoursesToConsole();

        //Display student full name
        System.out.println(students[0].getFullName());

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
        courseManager.returnAverageProfGrade("Anton Panaitescu");
    }
}
