package com.example.demoproject.java_practice;

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;


}
public class Enumaration {

    Day day;

    Enumaration(Day day){
        this.day = day;
    }
    public void isDayLike() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        Color objColor = Color.RED;
        System.out.println(objColor);

        String str = "MONDAY";
        Enumaration objEnum = new Enumaration(Day.valueOf(str));
        objEnum.isDayLike();

        Day arr[] = Day.values();
        for(Day day: arr) {
            System.out.println(day + " at index " + day.ordinal() );
        }

        //with value
        Fruit arrFruit[] = Fruit.values();

        for(Fruit f : arrFruit) {
            System.out.println("Color of " + f + " is " + f.getColor());
        }

    }
}
enum Color {
    RED,
    GREEN,
    BLUE;

    Color() {
        System.out.println("Constructor called for " + this.toString());
    }
    public void colorInfo() {
        System.out.println("Colorrrrr");
    }
}

enum Fruit {
    APPLE("RED"),
    BANANA("YELLOW");

    private String color;

    Fruit(String color) {
        this.color = color;
    }

    public String  getColor() {
            return this.color;
    }
}

