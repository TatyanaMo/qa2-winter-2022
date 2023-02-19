package pageobject.model;

public class Passenger {
    private String firstName;
    private String lastName;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
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
