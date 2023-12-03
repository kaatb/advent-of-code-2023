import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.BDDAssertions.and
import org.junit.jupiter.api.Test

internal class CalibrationDocumentTest {

    @Test
    fun `create calibration document splits document in lines`() {
        val calibrationDocument = CalibrationDocument(
            """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()
        )
        assertThat(calibrationDocument.lines).containsExactly(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        )
    }

    @Test
    fun `calibration values gets first and last digit from line`() {
        assertThat(
            CalibrationDocument(
                """
            1abc2
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(12);
    }

    @Test
    fun `calibration values gets first and last digit from line even when digit is not first or last character`() {
        assertThat(
            CalibrationDocument(
                """
            pqr3stu8vwx
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(38);
    }

    @Test
    fun `calibration values gets first and last digit from line, multiple digits`() {
        assertThat(
            CalibrationDocument(
                """
            a1b2c3d4e5f
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(15);
    }

    @Test
    fun `calibration values gets first and last digit from line, only 1 digit available`() {
        assertThat(
            CalibrationDocument(
                """
            treb7uchet
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(77);
    }

    @Test
    fun `calibration values - multiple lines`() {
        assertThat(
            CalibrationDocument("""
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(12, 38, 15, 77);
    }

    @Test
    fun `calibration values - spelled out digits`() {
        assertThat(CalibrationDocument("""
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent()).calibrationValuesWithStringDigits
        ).containsExactly(29, 83, 13, 24, 42, 14, 76);
    }

    @Test
    fun `sum calibration values - multiple lines`() {
        assertThat(
            CalibrationDocument("""
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()
            ).sumOfCalibrationValues()
        ).isEqualTo(142);
    }

    @Test
    fun `sum calibration values - spelled out digits`() {
        assertThat(CalibrationDocument("""
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent()).sumOfCalibrationValues(true)
        ).isEqualTo(281);
    }

    @Test
    fun `input day1`() {
        val readText = {}.javaClass.getResource("/day-01.txt").readText()
        assertThat(CalibrationDocument(readText.trimIndent()).sumOfCalibrationValues()).isEqualTo(54304)
    }

    private fun calibrationDocumentValuesWithSpelledOutDigits(): Int {
        val readText = {}.javaClass.getResource("/day-01.txt").readText()
        assertThat(CalibrationDocument(readText.trimIndent()).sumOfCalibrationValues(true)).isEqualTo(54418)
    }
}