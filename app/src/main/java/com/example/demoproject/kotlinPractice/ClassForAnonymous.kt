package com.example.demoproject.kotlinPractice

open class Department(empname: String, id: Int) {
    init {
        println("empname: $empname, id: $id")
    }
    fun IT() = println("Welcome To My Domain and welcome to Our IT department.")
    fun Support() = println("Welcome To My Domain and welcome to Our Support department.")
    fun QA() = println("Welcome To My Domain and welcome to Our QA department.")
    fun Development() = println("Welcome To My Domain and welcome to Our Development department.")
    open fun HR() = println("Welcome To My Domain and welcome to Our HR department.")
}