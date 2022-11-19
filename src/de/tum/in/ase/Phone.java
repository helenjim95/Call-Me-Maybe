package de.tum.in.ase;

public class Phone {
    //TODO: Add nextPhoneId, id, brand, price, touchscreen attributes to the Phone class and implement the constructor with these attributes
    public int nextPhoneId;
    private int id;
    private String brand;
    private double price;
    private boolean touchscreen;
    //TODO: Implement getter and setter methods for the attributes id, brand, price, touchscreen
    private int count = 0;
    public Phone(String brand, double price, boolean touchscreen) {
        this.id = count;
        this.nextPhoneId = this.id + 1;
        this.brand = brand;
        this.price = price;
        this.touchscreen = touchscreen;
        count += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }

    //TODO: Implement the toString method for the Phone class
    public String toString() {
        return "";
    }
}
