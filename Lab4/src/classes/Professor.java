package classes;

public class Professor extends Person {
    /* since the Professor class now extends the Person class (which has existing
    name and surname members), we no longer need the firstName and lastName members */
    @Override
    public String toString() {
        return "Professor{" + "firstName=" + name + ", lastName=" + surname + '}';
    }

    public Professor() {
        this.name = " ";
        this.surname = " ";
    }
    //default constructor

    public Professor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return "Professor: {" + name + " " + surname + '}';
    }

    public String getProf() {
        return name + " " + surname;
    }
}
