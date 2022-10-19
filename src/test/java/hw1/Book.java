package hw1;

public class Book {
    private String name;
    private double numberOfPages;
    private String type;
    private String publishingHouse;
    private String color;

    //--------------GETTERS/SETTERS----------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(double numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
