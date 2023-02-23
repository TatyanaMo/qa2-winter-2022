package pageobject.model;

import org.apache.commons.lang3.RandomStringUtils;

public class Passenger {
    private String firstName;
    private String lastName;

    public Passenger(String firstName, String lastName) {
        /*if (firstName.equals("random")) {
            this.firstName = RandomStringUtils.randomAlphabetic(10);
        } else {
            this.firstName = firstName;
        }*/

       //uprowennij variant if/else
       this.firstName = firstName.equals("random") ?  RandomStringUtils.randomAlphabetic(10) : firstName;
       // |--------expression-----------------------|----------------true--------------------------|---false---

        this.lastName = lastName;
    }

    //sozdali nizhe toljko GETTERS (setters ne nuzhni, tak kak budem cherez konstruktor zapolnjatj):

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
