package com.example.demoproject.java_practice;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpression {
    public static void main(String[] args) {
        Draw objD = () -> {
            System.out.println("draw() method");
        };
        objD.draw();

        Add objAdd = (a,b) -> {
            return a + b;
        };
        System.out.println("Addition is : " + objAdd.add(10,20));

        List<String> newList = new ArrayList<String>();
        newList.add("One");
        newList.add("Two");
        newList.add("Three");

        newList.forEach(
                n -> System.out.println(n)
        );
    }
}
interface Draw{
    void draw();
}
interface Add {
    int add(int a, int b);
}