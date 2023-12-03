import day1.calibration.CalibrationDocumentV1
import day1.calibration.CalibrationDocumentV2
import day2.cubes.CubesGame
import java.util.*

fun main() {
    println("day 01 - A >> " + calibrationDocumentValues())
    println("day 01 - B >> " + calibrationDocumentValuesWithSpelledOutDigits())

    val cubesGames = cubesGames()
    println("day 02 - A >> " + cubesGames.sumPossibleGames(12, 13, 14))
    println("day 02 - B >> " + cubesGames.sumPowerOfGames())
}

private fun cubesGames(): CubesGame {
    val readText = getInput("day-02.txt").trimIndent().split("\n".toRegex()).dropLastWhile { it.isEmpty() }
        .toTypedArray().toList();
    return CubesGame(readText)
}

private fun calibrationDocumentValues(): Int {
    val readText = getInput("day-01.txt")
    return CalibrationDocumentV1(readText.trimIndent()).sumOfCalibrationValues
}

private fun calibrationDocumentValuesWithSpelledOutDigits(): Int {
    val readText = getInput("day-01.txt")
    return CalibrationDocumentV2(readText.trimIndent()).sumOfCalibrationValues
}

private fun getInput(fileName: String): String {
    return {}.javaClass.getResource("/$fileName").readText()
}

