package day7.camelcards


class CamelCardHand(cardsString: String, val bid: Int, val joker: Boolean = false) : Comparable<CamelCardHand> {
    val strength: Strength;
    private val cards: List<Card>;
    private val chosenCardsComparator: Comparator<List<Card>>;

    init {
        cards = cardsString.toCharArray().map { Card.forValue(it.toString()) }.toList()
        chosenCardsComparator = if (joker) jokercardsComparator else cardsComparator
        strength = if (joker) strengthWithJoker() else strength()
    }

    override fun toString(): String {
        return "$cards $strength $bid"
    }

    override fun compareTo(other: CamelCardHand): Int = when {
        this.strength != other.strength -> strengthComparator.compare(this.strength, other.strength)
        this.cards != other.cards -> chosenCardsComparator.compare(this.cards, other.cards)
        else -> 0
    }

    private fun strength(): Strength {
        return Strength.determine(cards.groupingBy { it }.eachCount().values.sortedDescending())
    }

    private fun strengthWithJoker(): Strength {
        val groupedCards =
            this.cards.filter { it != Card.JACK }
                .groupingBy { it }.eachCount()
                .values
                .sortedDescending()
                .toMutableList()
        if (groupedCards.isEmpty()) groupedCards.add(0, 0)
        groupedCards[0]+= getNumberOfJokers()

        return Strength.determine(groupedCards)
    }

    private fun getNumberOfJokers(): Int {
        return this.cards.count { it == Card.JACK }
    }
}

val strengthComparator = Comparator<Strength> { one, two ->
    one.value - two.value
}

val cardsComparator = Comparator<List<Card>> { listOne, listTwo ->
    compareCards(listOne, listTwo) { x -> x.first.compareTo(x.second) }
}

val jokercardsComparator = Comparator<List<Card>> { listOne, listTwo ->
    compareCards(listOne, listTwo) { x -> x.first.jokerValue.compareTo(x.second.jokerValue) }
}

private fun compareCards(
    listOne: List<Card>,
    listTwo: List<Card>,
    comparisonPerCard: (input: Pair<Card, Card>) -> Int
): Int {
    val unequalCards = listOne.zip(listTwo)
        .filter { pair -> pair.first != pair.second }
        .toList()
    return if (unequalCards.isEmpty()) 0 else comparisonPerCard(unequalCards.get(0))
}


enum class Strength(val value: Int) {
    FIVE_OF_A_KIND(7),
    FOUR_OF_A_KIND(6),
    FULL_HOUSE(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(1);

    companion object {
        fun determine(numberOfSameCards: List<Int>): Strength {
            if (numberOfSameCards.contains(5)) {
                return FIVE_OF_A_KIND
            } else if (numberOfSameCards.contains(4)) {
                return FOUR_OF_A_KIND
            } else if (numberOfSameCards.contains(3) && numberOfSameCards.contains(2)) {
                return FULL_HOUSE
            } else if (numberOfSameCards.contains(3)) {
                return THREE_OF_A_KIND
            } else if (numberOfSameCards.count { it == 2 } == 2) {
                return TWO_PAIR
            } else if (numberOfSameCards.contains(2)) {
                return ONE_PAIR
            }
            return HIGH_CARD
        }
    }
}


enum class Card(val representation: String, val jokerValue: Int) {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 1),
    QUEEN("Q", 11),
    KING("K", 12),
    ACE("A", 13);

    companion object {
        fun forValue(value: String): Card {
            return entries.first { it.representation.equals(value) }
        }
    }
}

