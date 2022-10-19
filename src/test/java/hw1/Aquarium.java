package hw1;

public class Aquarium {
    private double height;
    private double length;
    private double width;
    private double weight;
    private boolean AquariumContainsFish;

    //--------------GETTERS/SETTERS----------------
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAquariumContainsFish() {
        return AquariumContainsFish;
    }

    public void setAquariumContainsFish(boolean aquariumContainsFish) {
        AquariumContainsFish = aquariumContainsFish;
    }
}
