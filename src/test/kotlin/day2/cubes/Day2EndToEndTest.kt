package day2.cubes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2EndToEndTest {

    @Test
    fun `input day2 A`() {
        val readText = {}.javaClass.getResource("/day-02.txt").readText().lines();
        assertThat(CubesGame(readText).sumPossibleGames(12, 13, 14)).isEqualTo(2164)
    }

    @Test
    fun `input day2 B`() {
        val readText = {}.javaClass.getResource("/day-02.txt").readText().lines();
        assertThat(CubesGame(readText).sumPowerOfGames()).isEqualTo(69929)
    }

}