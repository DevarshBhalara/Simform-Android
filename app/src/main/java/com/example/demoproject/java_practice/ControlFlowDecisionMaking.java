package com.example.demoproject.java_practice;

public class ControlFlowDecisionMaking {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if (a < b) {
            System.out.println("a is small");
        }else{
            System.out.println("B is small");
        }

        int num = 20;
        switch(num) {
            case 5 :  System.out.println("It is 5");

            case 10 : System.out.println("It is 10");

            case 15 : System.out.println("It is 15");

        }


        for (int i = 0; i <= 10 ;i++){
            if (i % 2 == 0)
                continue;

            System.out.println(i);
        }

        int count = 0;
        while (count <= 10){
            System.out.println(count);
            count++;
        }
    }
}
