package com.example.demoproject.kotlinPractice.Delegation

class CookieShop : CookieInterface {

    override fun cookieWasBacked(cookie: CookieData) {
        println("Cookie was backed with size ${cookie.size}")
    }

    override fun preferredCookieSize(size: Int): Int {
        return if (size > 12) {
            12
        } else {
            size
        }
    }

    override fun hasChocoChips(cookie: CookieData): Boolean {
        return cookie.hasChocolateChips
    }
}