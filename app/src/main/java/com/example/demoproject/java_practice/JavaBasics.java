
public class JavaBasics {
    public static void main(String[] args){
        System.out.println("Hello");

        Dog objDog = new Dog();
        objDog.bark();
        objDog.eat();


        Bike b = new Splendor();//upcasting
        b.run();

        CalculateAverage objStudent1 = new CalculateAverage("Devarsh",60,70,66);
        objStudent1.calcAverage();

    }
}
class Student{
    String name;
    int erNo;
    int subOneMark;
    int subTwoMark;
    int subThreeMark;

    Student(String name, int subOneMark, int subTwoMark, int subThreeMark){
        this.name = name;
        this.subOneMark = subOneMark;
        this.subTwoMark = subTwoMark;
        this.subThreeMark = subThreeMark;
    }
}
class CalculateAverage extends Student {

    CalculateAverage(String name, int subOneMark, int subTwoMark, int subThreeMark) {
        super(name, subOneMark, subTwoMark, subThreeMark);
    }

    void calcAverage(){
        float percentage = ( this.subOneMark + this.subTwoMark + this.subThreeMark ) / 3  ;
        System.out.println("Avearge is " + percentage);
    }
}


class Animal{
    void eat(){
        System.out.println("eatingg..");
    }
}
class Dog extends  Animal {
    void bark(){
        System.out.println("barking...");
    }
}
class Cat extends  Animal {
    void meow(){
        System.out.println("mewowwwww");
    }
}

//overriding
class Bike{
    void run(){System.out.println("running");}
}
class Splendor extends Bike{
    void run(){System.out.println("running safely with 60km");}


}