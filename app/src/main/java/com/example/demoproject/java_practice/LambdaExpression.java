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

        ClassPassingLambdaAsArgument objClass = new ClassPassingLambdaAsArgument();

        boolean result = objClass.check((x) ->  { System.out.println("Inside Main methods"); return (x%2) == 0; } , 10);
        System.out.println( "Result is " + result);

        String passSomething = "My name is Devarsh";
        objClass.checkPrintSomethings( (str) -> { System.out.println("Passed argument is : " + str); } , passSomething  );


    }
}
interface Draw{
    void draw();
}

interface Add {
    int add(int a, int b);
}

//passing lambda as argument
class ClassPassingLambdaAsArgument{
    boolean check(PassingLambdaAsArgument lambdaVariable, int b){
        System.out.println("Inside Class methods");
        System.out.println(lambdaVariable);
        return lambdaVariable.test(b);
    }

    void checkPrintSomethings(PrintSomething printSomething, String str){
        System.out.println("Inside checkPrintSomething");
        printSomething.printSomethingMethod(str);
    }

}
@FunctionalInterface
interface PassingLambdaAsArgument{
    boolean test(int a);
}

interface PrintSomething{
    void printSomethingMethod(String str);
}