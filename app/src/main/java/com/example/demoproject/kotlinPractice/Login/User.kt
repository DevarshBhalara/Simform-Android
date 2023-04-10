package com.example.demoproject.kotlinPractice.Login

class User {
    data class UserDetail(val email: String, val password: String, val role: Role) {
        override fun toString(): String {
            return "Email : $email, Password = ${
                password.replace(
                    Regex("[a-z0-9@/+=?]"),
                    "*"
                )
            }, Role: $role"
        }
    }

    enum class Role {
        NORMAL_USER,
        ADMIN
    }
}

fun interface Testtt {
    fun method1()
}

fun main() {
    Testtt {
        println("aa")
    }

}

fun testCall(x: String, lambda: Testtt) {

}