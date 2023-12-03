package day1.calibration

import StringToDigit
import java.util.*

class CalibrationDocumentV2(document: String) {
    val lines: List<String>

    init {
        val split = ArrayList<String>()
        split.addAll(Arrays.asList(*document.split("\n".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()))
        lines = split.toList()
    }

    val calibrationValues: List<Int>
        get() = lines
            .map { (it.getFirstDigit() + it.getLastDigit()).toInt() }
            .toList()

    val sumOfCalibrationValues: Int
        get() = calibrationValues.sum()

    private fun String.getFirstDigit(stringDigits: Boolean = false): String {
        if (this.first().isDigit()) {
            return this.first().toString()
        } else {
            StringToDigit.spelledOutDigits.map {
                if (this.startsWith(it.key)) {
                    return it.value.getFirstDigit()
                }
            }
        }
        return this.substring(1).getFirstDigit(stringDigits)
    }

    private fun String.getLastDigit(stringDigits: Boolean = false): String {
        if (this.last().isDigit()) {
            return this.last().toString()
        } else {
            StringToDigit.spelledOutDigits.map {
                if (this.endsWith(it.key)) {
                    return it.value.getFirstDigit()
                }
            }
        }
        return this.substring(0, this.length - 1).getLastDigit(stringDigits)
    }
}
