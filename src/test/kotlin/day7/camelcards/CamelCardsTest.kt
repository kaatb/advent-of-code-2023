package day7.camelcards

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CamelCardsTest{

    @Test
    fun camelcards() {
        assertThat(CamelCards("""32T3K 765
T55J5 684
KK677 28
KTJJT 220
QQQJA 483""").totalWinnings).isEqualTo(6440)
    }

    @Test
    fun camelcardsWithJoker() {
        assertThat(CamelCards("""32T3K 765
T55J5 684
KK677 28
KTJJT 220
QQQJA 483""", true).totalWinnings).isEqualTo(5905)
    }

    @Test
    fun `two and jack returns one pair`() {
        assertThat(CamelCards("2J68Q 415", true).hands.get(0).strength).isEqualTo(Strength.ONE_PAIR)
    }

    @Test
    fun `JJ9JQ returns four of a kind on Q`() {
        val camelCards = CamelCards(
            """JJTJQ 200
                |JJJJJ 300
                |JJ9JQ 400""".trimMargin(), true
        )
        assertThat(camelCards.hands[0].strength).isEqualTo(Strength.FOUR_OF_A_KIND)
        assertThat(camelCards.hands[0].bid).isEqualTo(400)
        assertThat(camelCards.hands[1].strength).isEqualTo(Strength.FOUR_OF_A_KIND)
        assertThat(camelCards.hands[1].bid).isEqualTo(200)
        assertThat(camelCards.hands[2].strength).isEqualTo(Strength.FIVE_OF_A_KIND)
        assertThat(camelCards.hands[2].bid).isEqualTo(300)
    }

    @Test
    fun `J22AJ returns four of a kind`() {
        val camelCards = CamelCards(
            """J22AJ 200""".trimMargin(), true
        )
        assertThat(camelCards.hands[0].strength).isEqualTo(Strength.FOUR_OF_A_KIND)
    }
}