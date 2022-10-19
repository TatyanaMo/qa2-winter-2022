package hw1;

public class Glass {
    private String material;
    private double volume;
    private double height;
    private String brand;
    private boolean glassForWine;

    //--------------GETTERS/SETTERS----------------

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isGlassForWine() {
        return glassForWine;
    }

    public void setGlassForWine(boolean glassForWine) {
        this.glassForWine = glassForWine;
    }
}
