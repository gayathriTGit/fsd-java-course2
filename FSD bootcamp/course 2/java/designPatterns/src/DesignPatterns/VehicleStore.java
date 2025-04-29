package DesignPatterns;

public class VehicleStore {

    private VehicleFactory factory;

    public VehicleStore(VehicleFactory factory) {
        this.factory = factory;
    }

    public void sellVehicle(String type) {
        Vehicle vehicle = VehicleFactory.CreateVehicle(type);
        System.out.println("Selling: " + vehicle.getName() + " for " + vehicle.getPrice() + " dollars.");
    }

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        VehicleStore store = new VehicleStore(factory);
        store.sellVehicle("car");
        store.sellVehicle("bike");
        store.sellVehicle("truck");
    }
}