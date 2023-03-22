package com.example.demoproject.kotlinPractice.functionAndExtension

class Math {
    // user defined infix member function
    infix fun square(n: Int): Int {
        val num = n * n
        return num
    }
}
