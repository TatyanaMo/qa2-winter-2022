package hw1;

public class Employee {
    private String name;
    private String surname;
    private String position;
    private float workExperience;
    private String workDepartment;

    //--------------GETTERS/SETTERS----------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(float workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorkDepartment() {
        return workDepartment;
    }

    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }
}
