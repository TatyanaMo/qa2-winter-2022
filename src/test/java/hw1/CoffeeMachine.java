package hw1;

public class CoffeeMachine {
    private String model;
    private String color;
    private boolean CoffeeMachineNew;
    private double height;
    private int watertankvolume;

    //--------------GETTERS/SETTERS----------------

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCoffeeMachineNew() {
        return CoffeeMachineNew;
    }

    public void setCoffeeMachineNew(boolean coffeeMachineNew) {
        CoffeeMachineNew = coffeeMachineNew;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWatertankvolume() {
        return watertankvolume;
    }

    public void setWatertankvolume(int watertankvolume) {
        this.watertankvolume = watertankvolume;
    }
}
