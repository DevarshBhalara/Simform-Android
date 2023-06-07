package com.example.demoproject.kotlinPractice.Delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FormatDelegate : ReadWriteProperty<Any?, String> {
    private var str: String = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("Getter called")
        return str
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("Setter called")
        if (thisRef is Person) {
            thisRef.updateCount++
        }
        str = value.lowercase().capitalize()
    }
}