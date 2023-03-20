package com.example.demoproject.kotlinPractice.Delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val objPerson = Person("devarsh", "bhalara" )
    objPerson.name = "devarsh"
    objPerson.lastname = "bhalara"
    println(objPerson.name)
    println("total updated  ${objPerson.updateCount} times")

}

class Person(name: String, lastname: String) {
    var name: String by FormatDelegate()
    var lastname: String by FormatDelegate()
    var updateCount = 0
}

class FormatDelegate : ReadWriteProperty<Any?, String> {
    private var str: String = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("Getter called")
        return str
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("Setter called")
        if (thisRef is Person){
            thisRef.updateCount++
        }
        str = value.lowercase().capitalize()
    }
}