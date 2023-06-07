package com.example.demoproject.kotlinPractice.practice

sealed class HttpError(val code: Int) {
    object Unathorized : HttpError(401)
    object NotFound : HttpError(404)
}

enum class HttpErrorEnum(val code: Int) {
    Unathorized(401),
    NotFound(404)
}

fun main() {
    val error: HttpError = HttpError.Unathorized
    when (error) {
        HttpError.NotFound -> println("Not Found")
        HttpError.Unathorized -> println("Unauthorized")
    }

    val errorEnum: HttpErrorEnum = HttpErrorEnum.Unathorized
    when (errorEnum) {
        HttpErrorEnum.NotFound -> println("Not Found")
        HttpErrorEnum.Unathorized -> println("Unauthorized")
    }


}