package com.example.demoproject.kotlinPractice.exception

fun main() {
    test("qwer")
    test("qweasdzxc")

}
fun test(password: String) {
    if (password.length < 8) {
        throw ArithmeticException("Password is short")
    }else{
        println("Strong Password")
    }
}