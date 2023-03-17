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

}

class Employee {
    var firstName: String = ""
    var age: Int = 0
}