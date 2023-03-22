package com.example.demoproject.kotlinPractice.generics

interface Compare2<in T> {
    fun compare(first: T, second: T): Int
//    fun test(): T T is in so can't d
}