package com.example.demoproject.kotlinPractice.exercise

class Bob {

    fun askQns(qns: String) {

        when {
            qns.contains(Regex("/[^a-zA-z0-9]+/")) -> println("Calm Down, I know what i'm doing!")
            qns.isEmpty() -> println("Fine. Be that way!")
            qns.uppercase() == qns && qns[qns.count() - 1] == '?' -> println("Calm Down, I know what i'm doing!")
            qns[qns.count() - 1] == '?' -> println("Sure")
            qns.uppercase() == qns -> println("Whoa! chill out")

            else -> {
                println("Whatever")
            }
        }
    }
}

fun main() {
    val objBob = Bob()
    objBob.askQns("How are you?")
    objBob.askQns("I AM YELLING AT YOU")
    objBob.askQns("I AM YELLING AT YOU?")
    objBob.askQns("ZOMG THE %^*@#(*^ ZOMBIES ARE COMING!!11!!1!")
    objBob.askQns(":) ?")

    var x = 1
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

}