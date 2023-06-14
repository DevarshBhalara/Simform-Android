package com.example.demoproject.kotlinPractice.Delegation

fun main() {
    val objBakery = Bakery(CookieShop())
    objBakery.makeCookie()
}