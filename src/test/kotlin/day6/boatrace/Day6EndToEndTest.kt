package day6.boatrace

import day2.cubes.CubesGame
import day3.gearratio.EngineSchematic
import day3.gearratio.EngineSchematicV2
import day4.scratchcard.ScratchCards
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day6EndToEndTest {

    @Test
    fun `input day6 A`() {
        val readText = {}.javaClass.getResource("/day-06.txt").readText();
        assertThat(BoatRace(readText).getMarginError()).isEqualTo(449550)
    }

    @Test
    fun `input day6 B`() {
        val readText = {}.javaClass.getResource("/day-06.txt").readText();
        assertThat(BoatRaceV2(readText).getMarginError()).isEqualTo(28360140)
    }

}