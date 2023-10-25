package classes;

public class Course {
    String name;
    String description;
    Professor teacher;
    Student[] students;
    float averageGrade;

    public Course(String name, String description, Professor teacher, Student[] students, float averageGrade) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = students;
    }

    public void updateProfessor(Professor teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
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
    public String toString() {
        String str = "Course: " + "name=" + name + ", description=" +
                description + ",\nTeacher=" + teacher + ",\nStudents:\n";
        for (Student s : students) {
            str += s + "\n";
        }
        return str;
    }
}
