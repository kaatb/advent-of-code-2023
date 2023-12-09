package day7.camelcards

import day2.cubes.CubesGame
import day3.gearratio.EngineSchematic
import day3.gearratio.EngineSchematicV2
import day4.scratchcard.ScratchCards
import day6.boatrace.BoatRace
import day6.boatrace.BoatRaceV2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day7EndToEndTest {

    @Test
    fun `input day7 A`() {
        val readText = {}.javaClass.getResource("/day-07.txt").readText();
        assertThat(CamelCards(readText).totalWinnings).isEqualTo(249726565)
    }

    @Test
    fun `input day7 B`() {
        val readText = {}.javaClass.getResource("/day-07.txt").readText();
        assertThat(CamelCards(readText, true).totalWinnings).isEqualTo(251135960)
    }

}