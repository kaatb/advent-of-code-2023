package day4.scratchcard

class ScratchCards(input: String) {

    private val scratchCards: List<ScratchCard>

    init {
        this.scratchCards =
            input.lines().map {
                ScratchCard(
                    getCardNumber(it).toInt(),
                    splitOnSpace(it, "(?<=\\:)(.*?)(?=\\|)"),
                    splitOnSpace(it, "(?<=\\|)(.*)")
                )
            }
    }

    private fun getCardNumber(it: String) = Regex("(?<=Card)(.*?)(?=:)").find(it)!!.value.trim()

    private fun splitOnSpace(it: String, substringRegex: String) =
        Regex(" ").split(Regex(substringRegex).find(it)!!.value)
            .filter { it.isNotEmpty() }

    val points: Int
        get() = scratchCards.map { it.points }.sum()

    fun totalScratchCards(): Long {
        scratchCards.forEach { originalCard -> originalCard.winningCopies.forEach {
            scratchCards.get(it - 1).numberOfOriginalCardsAndCopies+= originalCard.numberOfOriginalCardsAndCopies
        }}
        return scratchCards.map { it.numberOfOriginalCardsAndCopies }.sum()
    }
}