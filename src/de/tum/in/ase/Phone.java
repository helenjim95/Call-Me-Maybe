package de.tum.in.ase;

public class Phone {
    //Done: Add nextPhoneId, id, brand, price, touchscreen attributes to the Phone class and implement the constructor with these attributes
    public static int nextPhoneId = 0;
    private int id = -1;
    private String brand;
    private double price;
    private boolean touchscreen;
    //Done: Implement getter and setter methods for the attributes id, brand, price, touchscreen
    public Phone(String brand, double price, boolean touchscreen) {
        this.id = ++nextPhoneId;
        this.brand = brand;
        this.price = price;
        this.touchscreen = touchscreen;
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

    //Done: Implement the toString method for the Phone class
    public String toString() {
        return "";
    }
}
