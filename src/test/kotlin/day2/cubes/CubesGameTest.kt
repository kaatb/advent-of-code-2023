package day2.cubes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CubesGameTest {

    @Test
    fun `game number is extracted`() {
        assertThat(CubesGame(listOf("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).games.get(0).gameNumber)
            .isEqualTo(1)
        assertThat(CubesGame(listOf("Game 12: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).games.get(0).gameNumber)
            .isEqualTo(12)
    }

    @Test
    fun `possible game number are added`() {
        assertThat(CubesGame(
            listOf(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
            )).sumPossibleGames(12, 13, 14)).isEqualTo(8)
    }

    @Test
    fun `power of games`() {
        assertThat(CubesGame(
            listOf(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
            )).sumPowerOfGames()).isEqualTo(2286)
    }
}