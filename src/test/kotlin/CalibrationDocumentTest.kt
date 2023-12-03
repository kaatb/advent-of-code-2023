import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CalibrationDocumentTest {
    @Test
    fun createCalibrationDocument() {
        val calibrationDocument = CalibrationDocument(
            """
    1abc2
    pqr3stu8vwx
    a1b2c3d4e5f
    treb7uchet
    """.trimIndent()
        )
        Assertions.assertThat(calibrationDocument.lines).containsExactly(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        )
    }
}