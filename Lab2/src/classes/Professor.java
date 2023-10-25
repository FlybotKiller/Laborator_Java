package classes;

public class Professor {
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "Professor{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public Professor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return "Professor: {" + firstName + " " + lastName + '}' ;
        //Ex 1: this method returns a teacher's full name in the format FirstName LastName
    }

    public String getProf() {
        return firstName + " " + lastName;
    }
}
