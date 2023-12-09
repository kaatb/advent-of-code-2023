package day7.camelcards

class CamelCards(input: String, joker: Boolean = false) {

    val hands: List<CamelCardHand>

    init {
        hands = input.lines()
            .flatMap { it.split(" ").zipWithNext() }
            .map { CamelCardHand(it.first, it.second.toInt(), joker) }
            .toList()
            .sorted()
    }

   val totalWinnings: Int
    get() = hands.mapIndexed { index, it ->
        it.bid * (index + 1)
     }.sum()
}