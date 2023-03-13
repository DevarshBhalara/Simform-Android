package com.example.demoproject.java_practice;

public class ObjectCreate {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test a = new Test();
        Test objTest = (Test) Class.forName("Test").newInstance();
//        Test objTest2 = (Test) a.clone();
    }
}
class Test {

}