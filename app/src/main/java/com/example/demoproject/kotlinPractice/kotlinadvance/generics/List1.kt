package com.example.demoproject.kotlinPractice.generics

interface List1<out E> {
    fun get(index: Int): E
//    fun set(index: E) E is out so can't declare in method
}