import day1.calibration.CalibrationDocumentV1
import day1.calibration.CalibrationDocumentV2
import day2.cubes.CubesGame
import day3.gearratio.EngineSchematic
import day3.gearratio.EngineSchematicV2
import day4.scratchcard.ScratchCards
import java.util.*

fun main() {
    println("day 01 - A >> " + calibrationDocumentValues())
    println("day 01 - B >> " + calibrationDocumentValuesWithSpelledOutDigits())

    val cubesGames = cubesGames()
    println("day 02 - A >> " + cubesGames.sumPossibleGames(12, 13, 14))
    println("day 02 - B >> " + cubesGames.sumPowerOfGames())

    println("day 03 - A >> " + EngineSchematic(getInput("day-03.txt")).allNumbers)
    println("day 03 - B >> " + EngineSchematicV2(getInput("day-03.txt")).gearRatios)

    println("day 04 - A >> " + ScratchCards(getInput("day-04.txt")).points)
}

private fun cubesGames(): CubesGame {
    val readText = getInput("day-02.txt").lines();
    return CubesGame(readText)
}

private fun calibrationDocumentValues(): Int {
    val readText = getInput("day-01.txt")
    return CalibrationDocumentV1(readText).sumOfCalibrationValues
}

private fun calibrationDocumentValuesWithSpelledOutDigits(): Int {
    val readText = getInput("day-01.txt")
    return CalibrationDocumentV2(readText).sumOfCalibrationValues
}

private fun getInput(fileName: String): String {
    return {}.javaClass.getResource("/$fileName").readText()
}

