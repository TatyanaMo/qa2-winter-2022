package hw2transport;

public class Transport {
    private String vehicleType;
    private double fuelConsumption;
    private double tankVolume;

//----------------CONSTRUCTORS-------------------
    public Transport() {

    }

    public Transport(String vehicleType, double fuelConsumption, double tankVolume){
        this.vehicleType = vehicleType;
        this.fuelConsumption = fuelConsumption;
        this.tankVolume = tankVolume;
    }

//----------------GETTERS/SETTERS----------------
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }
}
