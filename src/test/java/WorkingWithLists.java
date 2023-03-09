import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    @Test
    public void createAndWorkWithLists () {
        Student valera = new Student();
        valera.setFirstName("Valera");
        valera.setLastName("The Tester");
        valera.setEmail("valerunchik@test.lv");
        valera.setPhone("+37123232323");

        Student liga = new Student("Liga", "Ivanova", "liga@test.lv", "+37122222222");
        Student dimko = new Student("Dimko", "Skatinishe", "omg@test.lv", "02");
        Student artis = new Student("Artis", "Greatest", null, "112");

        List<Student> students = new ArrayList<>();
        students.add(valera);
        students.add(liga);
        students.add(dimko);
        students.add(artis);


        for (int i = 0; i < students.size(); i++) {    // i = i + 1 --> i++
            System.out.println(students.get(i).getFirstName());
        }


        for (Student s : students) {
            System.out.println(s.getFullName());
        }


        System.out.println("printing students with phone number starting with +371");
        for (Student s: students) {
            if (s.getPhone().startsWith("+371")) {
                System.out.println(s.getFullName());

            }

        }
    }
}
