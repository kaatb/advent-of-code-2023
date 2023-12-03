import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1EndToEndTest {

    @Test
    fun `input day1 A`() {
        val readText = {}.javaClass.getResource("/day-01.txt").readText()
        assertThat(CalibrationDocumentV1(readText.trimIndent()).sumOfCalibrationValues).isEqualTo(54304)
    }

    @Test
    fun `input day1 B`() {
        val readText = {}.javaClass.getResource("/day-01.txt").readText()
        assertThat(CalibrationDocumentV2(readText.trimIndent()).sumOfCalibrationValues).isEqualTo(54418)
    }
}