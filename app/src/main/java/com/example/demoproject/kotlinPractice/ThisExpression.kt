package com.example.demoproject.kotlinPractice

class A { // implicit label @A
    inner class B {
        var a = this@A// implicit label @B
        fun foo() { // implicit label @foo
            val a = this@A // A's this
            val b = this@B // B's this

            val c = this // foo()'s receiver, an Int
//            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit's receiver, a String
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }
        }
    }

}


fun main() {

    fun printLine() { println("Top-level function") }

    class A1 {
        fun printLine() { println("Member function") }

        fun invokePrintLine(omitThis: Boolean = false)  {
            if (omitThis) printLine()
            else this.printLine()
        }
    }


    val objB = A().B()
    objB.foo()

    val objA1 = A1()
    objA1.printLine()

    objA1.invokePrintLine()
    objA1.invokePrintLine(true)
}