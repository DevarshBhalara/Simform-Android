package com.example.demoproject.java_practice;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float a;
        float b;

        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);

        if (a == b) {
            System.out.println("Equal");
        }else {
            System.out.println("Not equal");
        }

        int varC = 5;
        int varD = 7;

        System.out.println((varC & varD));
    }
}
