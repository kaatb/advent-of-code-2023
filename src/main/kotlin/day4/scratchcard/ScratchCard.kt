package day4.scratchcard

class ScratchCard(val cardNumber: String, val winningNumbers: List<String>, val ownNumbers: List<String>) {

    val points: Int
        get() = ownNumbers.filter { winningNumbers.contains(it) }
            .foldIndexed(0) { i, acc, value -> if (i == 0) 1 else acc * 2 }
}