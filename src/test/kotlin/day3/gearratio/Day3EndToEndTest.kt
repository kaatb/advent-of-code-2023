package day3.gearratio

import day2.cubes.CubesGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3EndToEndTest {

    @Test
    fun `input day3 A`() {
        val readText = {}.javaClass.getResource("/day-03.txt").readText();
        assertThat(EngineSchematic(readText).allNumbers).isEqualTo(540212)
    }

    @Test
    fun `input day3 A V2`() {
        val readText = {}.javaClass.getResource("/day-03.txt").readText();
        assertThat(EngineSchematicV2(readText).allNumbers).isEqualTo(540212)
    }

    @Test
    fun `input day3 B V2`() {
        val readText = {}.javaClass.getResource("/day-03.txt").readText();
        assertThat(EngineSchematicV2(readText).gearRatios).isEqualTo(87605697)
    }

}