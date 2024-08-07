package org.example

import org.testng.annotations.Test
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue

class TestHomeWork1 {
    private val hw1 = Homework1()

    // ./gradlew test --info로 실행 시 println까지 출력
    @Test
    fun testCalculateForEight() {
        val result = hw1.calculate(8)
        println("Calculated result for 8: $result")
        assertEquals(result.size, 8)
        assertEquals(result.last(), 72)
        println("Test for calculation with input 8 passed successfully")
    }

    @Test
    fun testCalculateForThree() {
        val result = hw1.calculate(3)
        println("Calculated result for 3: $result")
        assertEquals(result.size, 3)
        assertEquals(result.last(), 27)
        println("Test for calculation with input 3 passed successfully")
    }

    @Test
    fun testCalculateForTen() {
        val result = hw1.calculate(10)
        println("Calculated result for 10: $result")
        assertEquals(result.size, 10)
        assertEquals(result.first(), 9)
        assertEquals(result.last(), 90)
        println("Test for calculation with input 10 passed successfully")
    }
}