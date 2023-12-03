package day2.cubes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SingleGameTest {

    @Test
    fun `is game possible with configuration - not possible if number of cubes higher than configuration`() {
        assertThat(SingleGame(1, hashMapOf("blue" to listOf(6,3), "red" to listOf(2,4), "green" to listOf(2))).isPossible(4, 2, 6)).isTrue()
        assertThat(SingleGame(1, hashMapOf("blue" to listOf(6,3), "red" to listOf(2,4), "green" to listOf(2))).isPossible(3, 2, 6)).isFalse()
    }
}