package classes;

public class Classes {
    public static void main(String[] args) {
        //Define students
        Student[] students = new Student[]{new Student("Andrei", "Negoita",
                2231, 10), new Student("Ion", "Mateescu", 4221, 7)};
        Student stud = new Student("Stefan", "Stefanescu", 4562, 9);
        Student[] signals = new Student[]{new Student("Filip", "Marian",
                4622, 8), new Student("Florin", "Matei", 2221, 10)};

        //Define Professor
        Professor prof = new Professor("Anton", "Panaitescu");

        //Define new course
        Course course = new Course("Material Resistance", "Calculations of reactions,\n"
                + "effort diagrams, calculations of geometric characteristics of\n" +
                "flat surfaces and calculations of resistance elements to simple stresses\n",
                prof, students, 0);
        Course sscourse = new Course("Signals and Systems I", "Processing and analysis of signals",
                prof, signals, 0);

        //Add course to the list of courses
        CourseManager courseManager = new CourseManager();
        courseManager.addCourse(course);
        courseManager.addCourse(sscourse);

        //Enroll a student in a course
        courseManager.enrollStudent("Material Resistance", stud);

        //Display courses to the console
        courseManager.displayCoursesToConsole();

        //Display student full name
        System.out.println(students[0].getFullName());

        //Display teacher full name
        System.out.println(prof.getFullName());

        //List students in a course
        courseManager.listStudentsInCourse("Material Resistance");
        courseManager.listStudentsInCourse("Signals and Systems I");

        //Average course grade
        courseManager.returnAverageCourseGrade("Material Resistance");
        courseManager.returnAverageCourseGrade("Signals and Systems I");
        courseManager.returnAverageProfGrade("Anton Panaitescu");
    }
}
