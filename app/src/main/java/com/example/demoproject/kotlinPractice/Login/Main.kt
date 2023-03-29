package com.example.demoproject.kotlinPractice.Login

fun main() {
    val listUser = listOf(
        UserTest("name", 20),
        UserTest("name2", 22)
    )

    val ageIncrement = listUser.map {
        it.copy(age = it.age + 5)
    }
    println(ageIncrement)
}

data class UserTest(val name: String, val age: Int)