import org.testng.Assert.*
import org.testng.annotations.Test

class MultiplicationTableTest {

    // 함수: 특정 숫자의 구구단 결과 반환
    fun generateMultiplicationTable(number: Int): List<String> {
        require(number in 1..9) { "1부터 9까지의 숫자를 입력해야 합니다." }

        val results = mutableListOf<String>()
        for (i in 1..9) {
            results.add("$number * $i = ${number * i}")
        }
        return results
    }

    @Test
    fun testValidInput() {
        val number = 3
        val expectedResults = listOf(
            "3 * 1 = 3",
            "3 * 2 = 6",
            "3 * 3 = 9",
            "3 * 4 = 12",
            "3 * 5 = 15",
            "3 * 6 = 18",
            "3 * 7 = 21",
            "3 * 8 = 24",
            "3 * 9 = 27"
        )
        val actualResults = generateMultiplicationTable(number)
        assertEquals(actualResults, expectedResults, "3단 구구단 결과가 예상과 일치하지 않습니다.")
    }

    @Test
    fun testInvalidInput() {
        val number = 10
        try {
            generateMultiplicationTable(number)
            fail("1부터 9까지의 숫자가 아닌 입력에 대해서는 예외가 발생해야 합니다.")
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "1부터 9까지의 숫자를 입력해야 합니다.")
        }
    }

    @Test
    fun testBoundaryValues() {
        val validNumbers = listOf(1, 9)
        for (number in validNumbers) {
            val results = generateMultiplicationTable(number)
            assertEquals(results.size, 9, "구구단 결과가 9개의 항목을 포함해야 합니다.")
        }
    }
}
