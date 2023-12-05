package day3.gearratio

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EngineSchematicTest {
    @Test
    fun `should return all numbers combined`() {
        assertThat(
            EngineSchematic(
                """467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...${'$'}.*....
.664.598.."""
            ).allNumbers
        ).isEqualTo(4361)
    }
}