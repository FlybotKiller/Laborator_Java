package classes;

public class Course implements CourseOperations {
    String name;
    String description;
    Professor teacher;
    Student[] students;
    float averageGrade;

    public Course() {
        this.name = " ";
        this.description = " ";
        this.teacher = new Professor();
        this.students = new Student[0];
        this.averageGrade = 0.0f;
    }
    //default constructor

    public Course(String name, String description, Professor teacher, Student[] students, float averageGrade) {
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
        //Working with arrays, we need to insert by using an auxiliary array
        int newLength = students.length + 1;
        Student[] aux = new Student[newLength];
        int index = 0;
        for (Student s : students) {
            aux[index++] = s;
        }
        //Finally, we add the new student at the last index
        aux[index] = student;
        //And we reallocate the students list with aux
        this.students = new Student[newLength];
        System.arraycopy(aux, 0, students, 0, newLength);
    }

    @Override
    public void RemoveStudent(Student student) {
        int indexToRemove = -1;

        //Find the index of the student to remove
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            //Create a new array with length - 1
            Student[] newStudents = new Student[students.length - 1];

            //Copy students before the removed student
            if (indexToRemove > 0) {
                System.arraycopy(students, 0, newStudents, 0, indexToRemove);
            }

            //Copy students after the removed student
            if (indexToRemove < students.length - 1) {
                System.arraycopy(students, indexToRemove + 1, newStudents, indexToRemove, students.length - indexToRemove - 1);
            }

            //Assign the new array back to the 'students' field
            students = newStudents;
        }
    }

    @Override
    public void UpdateStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].grade < student.grade) {
                students[i] = student;
                return;
            }
        }
    }
    /* This method compares grades between students, the first array student with
    a lower grade than our replacement candidate is removed and replaced by the candidate */

    @Override
    public void UpdateCourse(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
