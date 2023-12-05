package day4.scratchcard

class ScratchCards(input: String) {

    private val scratchCards: List<ScratchCard>

    init {
        this.scratchCards =
            input.lines().map { ScratchCard(Regex("(?<=Card )(.*?)(?=:)").find(it)!!.value, splitOnSpace(it, "(?<=\\:)(.*?)(?=\\|)"), splitOnSpace(it, "(?<=\\|)(.*)")) }
    }

    private fun splitOnSpace(it: String, substringRegex: String) =
        Regex(" ").split(Regex(substringRegex).find(it)!!.value)
            .filter { it.isNotEmpty() }

    val points: Int
        get() = scratchCards.map { it.points }.sum()
}