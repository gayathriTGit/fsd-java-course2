package DesignPatterns;

public class Truck extends Vehicle {

    public Truck() {
        this.name = "Truck";
    }

    @Override
    public int getPrice() {
        return 35000;
    }
}
