package org.example

class Homework1 {
    fun calculate(number: Int): List<Int> {
        return (1..number).map { it * 9 }
    }
}