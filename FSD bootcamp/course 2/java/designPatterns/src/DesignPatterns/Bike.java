package DesignPatterns;

public class Bike extends Vehicle {

    public Bike() {
        this.name = "Bike";
    }

    @Override
    public int getPrice() {
        return 2000;
    }
}
