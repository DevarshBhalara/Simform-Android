package com.example.demoproject.kotlinPractice

fun main() {

    //let
    val numbers = mutableListOf("One","Two","Three","Four","Five")
    numbers.map { it.length }.filter { it > 3 }.let { println(it) }

    val list = mutableListOf(6, 1, 5, 2, 4, 3)
    list.filter {
        println("Filter called")
        it % 2 == 0 }
        .sortedBy {
        println("Inside sort")
        it
        }
        .let {
        println("Sorted even numbers are : $it")
    }

    //with

    val employee: Employee = Employee()
    val objEmployee = with(employee) {
        this.firstName = "Abc"
        this.age = 25

        "Name is $firstName and age is $age"
    }
    println(objEmployee)
    println(employee.firstName)

    employee.run {
        this.firstName = "New"
        println(this.firstName)
    }


    val person = Person()
    val personInfo : String = with (person){
        println(this.firstName)
        println(this.age)
        age + 10
        "I love the game of football"  //this well be stored in variable personInfo
    }
    println("Person info $personInfo")


}

class Person{
    var firstName: String = "Elena Wilson"
    var age: Int = 28
}


class Employee {
    var firstName: String = ""
    var age: Int = 0
}