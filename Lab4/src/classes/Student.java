package classes;

public class Student extends Person implements Comparable<Student> {
    /* since the Student class now extends the Person class (which has existing
    name and surname members), we no longer need the firstName and lastName members */
    int groupNumber;
    int grade;

    public Student() {
        this.name = " ";
        this.surname = " ";
        this.groupNumber = 0;
        this.grade = 0;
    }
    //default constructor

    public Student(String name, String surname, int groupNumber, int grade) {
        this.name = name;
        this.surname = surname;
        this.groupNumber = groupNumber;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + name + ", lastName=" + surname
                + ", groupNumber=" + groupNumber + ", grade=" + grade + '}';
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String firstName) {
        this.name = firstName;
    }

    public String getLastName() {
        return surname;
    }

    public void setLastName(String lastName) {
        this.surname = lastName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFullName() {
        return "Student: {" + name + " " + surname + '}';
    }

    @Override
    public int compareTo(Student other_student) {
        return this.name.compareTo(other_student.name);
    }
}
