package com.example.demoproject.kotlinPractice.Delegation

class Bakery(private val delegate: CookieInterface) : CookieInterface by delegate {

    fun makeCookie() {
        val cookieSize: Int = 14
        val cookie = CookieData(preferredCookieSize(cookieSize), true)
        cookieWasBacked(cookie)
    }
}