package DesignPatterns;

public class VehicleFactory {

    public static Vehicle CreateVehicle(String type) {
        switch (type.toLowerCase()){
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
