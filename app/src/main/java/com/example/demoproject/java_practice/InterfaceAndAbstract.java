package com.example.demoproject.java_practice;

public class InterfaceAndAbstract {
    public static void main(String[] args) {
        Rectangle objRectangle = new Rectangle();
        objRectangle.calculateArea(20,20);
    }
}

class Rectangle implements PolygonShape {

    @Override
    public void calculateArea(int length, int breadth) {
        System.out.println("Are is " + length * breadth);
    }
}

interface PolygonShape {
    void calculateArea(int length, int breadth);
}