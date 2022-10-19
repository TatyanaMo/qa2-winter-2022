package hw1;

import org.junit.jupiter.api.Test;

public class ObjectStudentPractice {
    @Test
    public void workingWithStudents () {
        Student studentOne = new Student();
        studentOne.setStudentID(12345);
        studentOne.setName("Harry");
        studentOne.setSurname("Potter");
        studentOne.setPersonalCode("111120-111111");

        Student studentTwo = new Student();
        studentTwo.setStudentID(36362);
        studentTwo.setName("Bilbo");
        studentTwo.setSurname("Baggins");
        studentTwo.setPersonalCode("121299-222222");

        System.out.println("List of students!");

        System.out.println("Student 1:");
        System.out.println(studentOne.getName() + " " + studentOne.getSurname());
        System.out.println(studentOne.getStudentID());

        System.out.println("Student 2:");
        System.out.println(studentTwo.getName() + " " + studentTwo.getSurname());
        System.out.println(studentTwo.getStudentID());

    }
}
