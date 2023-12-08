package day6.boatrace

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoatRaceTest {
    @Test
    fun `margin error`() {
        assertThat(
            BoatRace(
                """Time:      7  15   30
Distance:  9  40  200"""
            ).getMarginError()
        ).isEqualTo(288)
    }
}