package com.example.demoproject.kotlinPractice.Delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val objPerson = Person("devarsh", "bhalara")
    objPerson.name = "devarsh"
    objPerson.lastname = "bhalara"
    println(objPerson.name)
    println("total updated  ${objPerson.updateCount} times")

}



