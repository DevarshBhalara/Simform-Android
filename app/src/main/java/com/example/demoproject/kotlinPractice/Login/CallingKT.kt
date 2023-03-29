package com.example.demoproject.kotlinPractice.Login

//import com.example.demoproject.kotlinPractice.Login.Database.changeDetails
//import com.example.demoproject.kotlinPractice.Login.Database.getUser
import com.example.demoproject.kotlinPractice.Login.Database.changeDetails
import com.example.demoproject.kotlinPractice.Login.Database.getAllUser
import com.example.demoproject.kotlinPractice.Login.Database.getUser
import com.example.demoproject.kotlinPractice.Login.Database.users

fun main() {

    val user1 = User.UserDetail("abc@gmail.com", "qweasd", User.Role.NORMAL_USER)
    addUser(user1)

    val user2 = User.UserDetail("abc@gmail.com", "qweasd", User.Role.NORMAL_USER)
    addUser(user2)

    val admin1 = User.UserDetail("abc2@gmail.com", "qweasd", User.Role.ADMIN)
    addUser(admin1)

    println("=== GET ONE USER ===")
    println(getUser("abcg2@gmail.com"))

    getAllUser()

    println("=== CHANGING DETAILS ===")

    changeDetails(user2.copy(password = "123456"), admin1)

    println("=== AFTER CHANGING DETAILS ===")

    getAllUser()
}


//fun testFunction(param1: String, greet: Greet) {
//
//
//}
//
//fun interface Greet {
//    fun greetMethod()
//    fun hello() {
//        println("Hello")
//    }
//}

fun addUser(user: User.UserDetail) {
    if (users.containsKey(user.email)) {
        println("Email already exists")
        return
    }
    users[user.email] = user

}