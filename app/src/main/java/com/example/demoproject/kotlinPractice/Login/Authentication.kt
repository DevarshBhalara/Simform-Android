package com.example.demoproject.kotlinPractice.Login

interface Authentication {
    fun validateEmail(email: String): Boolean
}