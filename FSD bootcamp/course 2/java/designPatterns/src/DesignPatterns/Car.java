package DesignPatterns;

public class Car extends Vehicle {

    public Car() {
        this.name = "Car";
    }

    @Override
    public int getPrice() {
        return 20000;
    }
}
