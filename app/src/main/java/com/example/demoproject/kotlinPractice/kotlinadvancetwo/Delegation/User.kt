package com.example.demoproject.kotlinPractice.Delegation

//storing in map
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}
