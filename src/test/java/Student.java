public class Student {
    //----------ATTRIBUTES-----------
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    //----------CONSTRUCTORS--------

//Eto pustoj konstruktor (esli sozdaem potom studentov s pomowju setterov)
    public Student() {

    }
// eto konstruktor, cherez kotorij uzhe nozhno sozdavatj novih studentov, bez setterov
    public Student(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;  //cherez this. ukazivaem chto znachenie iz metoda prisvaevaetjsa znacheniju classa
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    //-----------GETTERS/SETTERS--------------------
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //---------CUSTOM METHODS--------------
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
