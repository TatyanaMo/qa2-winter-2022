package hw1;

public class Course {
    private String courseName;
    private String dateOfBeginning;
    private int studentAmount;
    private double price;
    private int courseDuration;

    //--------------GETTERS/SETTERS----------------

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDateOfBeginning() {
        return dateOfBeginning;
    }

    public void setDateOfBeginning(String dateOfBeginning) {
        this.dateOfBeginning = dateOfBeginning;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount = studentAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
}
