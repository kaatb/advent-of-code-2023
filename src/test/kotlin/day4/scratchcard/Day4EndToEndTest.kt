package day4.scratchcard

import day2.cubes.CubesGame
import day3.gearratio.EngineSchematic
import day3.gearratio.EngineSchematicV2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4EndToEndTest {

    @Test
    fun `input day4 A`() {
        val readText = {}.javaClass.getResource("/day-04.txt").readText();
        assertThat(ScratchCards(readText).points).isEqualTo(23750)
    }

    @Test
    fun `input day4 B`() {
        val readText = {}.javaClass.getResource("/day-04.txt").readText();
        assertThat(ScratchCards(readText).totalScratchCards()).isEqualTo(13261850)
    }

}