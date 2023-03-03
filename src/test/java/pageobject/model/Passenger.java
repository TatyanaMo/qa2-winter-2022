package pageobject.model;

import org.apache.commons.lang3.RandomStringUtils;

public class Passenger {
    private String firstName;
    private String lastName;

    public Passenger(String firstName, String lastName) {
       this.firstName = firstName.equals("random") ?  RandomStringUtils.randomAlphabetic(10) : firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
