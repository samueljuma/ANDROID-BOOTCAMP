package effectivekotlinbymarcinmoskala.safety

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


fun sumOfTwo(num1: Int, num2: Int): Int {
    return num1 + num2
}

class TestClass{

    @BeforeEach
    fun `do this before any test`(){
        print("Runs before tests")
    }
    @Test
    fun `sumOfTwo positive returns the result of the sum` (){
        Assertions.assertEquals(5, sumOfTwo(1, 4))
    }

    @Test
    fun `sumOfTwo negative returns the result of the sum` (){
        Assertions.assertEquals(-2, sumOfTwo(-1, -1))
    }
}




