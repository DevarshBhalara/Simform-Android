package com.example.demoproject.kotlinPractice.Login

object Database : Authentication {

    val users = mutableMapOf<String, User.UserDetail>()

    fun getUser(email: String) = users[email] ?: "User with $email this email doesn't exists"

    fun getAllUser() {
        users.forEach {
            println("Email is ${it.key} and Password is ${it.value.password} and role is ${it.value.role}")
        }
    }

    fun changeDetails(user: User.UserDetail, admin: User.UserDetail) {
        if (admin.role != User.Role.ADMIN) {
            println("You are not an admin")
            return
        }
        users.replace(user.email, user)?.let {
            println("User updated Successfully")
        } ?: println("Email id doesn't exists")

//        if (users.replace(user.email, user) == null) {
//            println("Email id doesn't exists")
//        }
//        println("User updated Successfully")

    }

    override fun validateEmail(email: String): Boolean {
        return users.containsKey(email)
    }


//    val users = mutableListOf<User.UserDetail>()
//    fun getUser(email: String) =
//        users.find {
//            it.email == email
//        }
//
//    fun getAllUser(): List<User.UserDetail> = users
//
//    fun changeDetails(user: User.UserDetail, admin: User.UserDetail) {
//        if (admin.role == User.Role.ADMIN) {
//            users.filter {
//                it.email == user.email
//            }.map {
//                user
//            }
//        }
//    }
}