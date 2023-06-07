package com.example.demoproject.java_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CollectionTypes {
    public static void main(String[] args) {


        /* Arraylist */
        ArrayList<String> cars = new ArrayList<String>(3);
//        System.out.println(cars.size() + " " + cars.get(0));
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);

        int newCar;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many new car you want to add ? ");
        newCar = sc.nextInt();

        for (int i=1; i<=newCar; i++) {
            System.out.println("Enter new car name : ");
            String car = sc.next();
            System.out.println("New car is " + car);
            cars.add(car);
        }
        System.out.println(cars);

        cars.add(2, "New");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("New1");
        arrayList2.add("New2");

        cars.addAll(arrayList2);

        System.out.println(cars.contains("BMW"));

        ArrayList<String> arrayList3 = new ArrayList<String>();
        arrayList3 = (ArrayList<String>) cars.clone();

        System.out.println("index of BMW is : " + cars.indexOf("BMW"));
        System.out.println("last index of BMW is : " + cars.lastIndexOf("BMW"));
        for (int i=0; i<cars.size(); i++)
            System.out.println(cars.get(i));

        cars.removeAll(arrayList2);
        System.out.println(cars);

        /* Map */

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("BMW", 5000000);
        map.put("A6",4000000);
        map.put("A4",4000000);
        map.put("A7",4000000);
        map.put("E-tron",4000000);

        System.out.println(map);

        //LinkedHashMap track insertion order
        Map<String, Integer> linkedMap = new LinkedHashMap<String, Integer>();
        linkedMap.put("BMW", 5000000);
        linkedMap.put("A6",4000000);
        linkedMap.put("A4",4000000);
        linkedMap.put("A7",4000000);
        linkedMap.put("E-tron",4000000);

        System.out.println(linkedMap);

        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("BMW", 5000000);
        treeMap.put("A6",4000000);
        treeMap.put("A4",4000000);
        treeMap.put("A7",4000000);
        treeMap.put("E-tron",4000000);

        treeMap.remove("BMW");
        for (Map.Entry mapElement : treeMap.entrySet()){
            String key = (String) mapElement.getKey();
            int values = (int) mapElement.getValue();
            System.out.println(key + " " + values);
        }
        System.out.println(treeMap);
    }
}
