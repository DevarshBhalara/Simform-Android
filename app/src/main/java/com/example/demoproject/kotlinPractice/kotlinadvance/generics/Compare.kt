package com.example.demoproject.kotlinPractice.generics

interface Compare<T> {
    fun campare(item1: T, item2: T): Int
}