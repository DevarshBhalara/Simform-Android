package com.example.demoproject.kotlinPractice.generics


abstract class Animal(val size: Int)
class Dog(val cuteness: Int): Animal(100)
class Spider(val terrorFactor: Int): Animal(1)

interface Compare<T> {
    fun campare(item1: T, item2: T): Int
}

interface List1<out E> {
    fun get(index: Int): E
//    fun set(index: E) E is out so can't declare in method
}

interface Compare2<in T> {
    fun compare(first: T, second: T): Int
//    fun test(): T T is in so can't d
}

fun main() {
    val dog: Dog = Dog(10)
    val spider: Spider = Spider(9000)
    var animal: Animal = dog
    animal = spider

    val dogList: List<Dog> = listOf(Dog(10), Dog(20))
    val animalList: List<Animal> = dogList


    val animalList2: List<Animal> = listOf()
//    val dogList2: List<Dog> = animalList

    val dogCompare: Compare<Dog> = object: Compare<Dog> {
        override fun campare(item1: Dog, item2: Dog): Int {
            return item1.cuteness - item2.cuteness
        }
    }

//    val animalCompare: Compare<Animal> = dogCompare error

    val animalCompare: Compare<Animal> = object: Compare<Animal> {
        override fun campare(item1: Animal, item2: Animal): Int {
            return item1.size - item2.size
        }
    }
//    val spiderCompare: Compare<Spider> = animalCompare
}