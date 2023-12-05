package day1.calibration

import java.util.*

class CalibrationDocumentV1(document: String) {
    val lines: List<String>

    init {
        lines = document.lines()
    }

    val calibrationValues: List<Int>
        get() = lines
            .map { it.getFirstDigit() + it.getLastDigit() }
            .map { Integer.parseInt(it) }
            .toList()

    val sumOfCalibrationValues: Int
        get() = calibrationValues.sum()

    private fun String.getFirstDigit(): String {
        if (this.first().isDigit()) {
            return this.first().toString()
        }
        return this.substring(1).getFirstDigit()
    }

    private fun String.getLastDigit(): String {
        if (this.last().isDigit()) {
            return this.last().toString()
        }
        return this.substring(0, this.length - 1).getLastDigit()
    }
}
