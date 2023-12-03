fun main() {
    println("day 01 - A >> " + calibrationDocumentValues())
    println("day 01 - B >> " + calibrationDocumentValuesWithSpelledOutDigits())
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

