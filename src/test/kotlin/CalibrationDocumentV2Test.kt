import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalibrationDocumentTest {

    @Test
    fun `create calibration document splits document in lines`() {
        val calibrationDocument = CalibrationDocumentV1(
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
            CalibrationDocumentV1(
                """
            1abc2
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(12);
    }

    @Test
    fun `calibration values gets first and last digit from line even when digit is not first or last character`() {
        assertThat(
            CalibrationDocumentV1(
                """
            pqr3stu8vwx
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(38);
    }

    @Test
    fun `calibration values gets first and last digit from line, multiple digits`() {
        assertThat(
            CalibrationDocumentV1(
                """
            a1b2c3d4e5f
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(15);
    }

    @Test
    fun `calibration values gets first and last digit from line, only 1 digit available`() {
        assertThat(
            CalibrationDocumentV1(
                """
            treb7uchet
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(77);
    }

    @Test
    fun `calibration values - multiple lines`() {
        assertThat(
            CalibrationDocumentV1("""
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()
            ).calibrationValues
        ).containsExactly(12, 38, 15, 77);
    }



    @Test
    fun `sum calibration values - multiple lines`() {
        assertThat(
            CalibrationDocumentV2("""
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
        assertThat(CalibrationDocumentV2("""
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
}