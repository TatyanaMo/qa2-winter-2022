package hw1;

public class Cat {
    private String name;
    private String color;
    private String breed;
    private int age;
    private double length;
    private double weight;
    private boolean catIsFat;


    //--------------GETTERS/SETTERS----------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isCatIsFat() {
        return catIsFat;
    }

    public void setCatIsFat(boolean catIsFat) {
        this.catIsFat = catIsFat;
    }
}
