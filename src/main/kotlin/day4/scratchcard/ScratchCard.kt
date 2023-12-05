package day4.scratchcard

class ScratchCard(val cardNumber: Int, val winningNumbers: List<String>, val ownNumbers: List<String>) {

    val countWinningNumbers: Int = ownNumbers.count { winningNumbers.contains(it) }

    var numberOfOriginalCardsAndCopies: Long = 1

    val points: Int
        get() = ownNumbers.filter { winningNumbers.contains(it) }
            .foldIndexed(0) { i, acc, value -> if (i == 0) 1 else acc * 2 }


    val winningCopies: List<Int>
        get() {
            if (countWinningNumbers == 0) {
                return listOf()
            } else {
                return IntRange(cardNumber + 1, cardNumber + countWinningNumbers).toList()
            }
        }
}