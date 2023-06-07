package com.example.demoproject.kotlinPractice.Delegation

interface CookieInterface {
    fun cookieWasBacked(cookie: CookieData)
    fun preferredCookieSize(size: Int): Int
    fun hasChocoChips(cookie: CookieData): Boolean
}