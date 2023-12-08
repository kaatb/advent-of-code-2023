package day6.boatrace

class BoatRaceV2(input: String) {

    val boatRaceRecord: Pair<Time, Distance>;

    init {
        val timeAndDistanceSeparateList = input.lines().map {
            it.split(" ")
                .filter { it.isNotBlank() && it.get(0).isDigit() }
                .joinToString(separator ="")
                .toLong()
        }.toList()
        boatRaceRecord = timeAndDistanceSeparateList.get(0) to timeAndDistanceSeparateList.get(1)
    }

    fun getMarginError(): Int {
        return LongRange(0, boatRaceRecord.first)
                .map { aantalSecondenKnopIngedrukt ->
                    aantalSecondenKnopIngedrukt * (boatRaceRecord.first - aantalSecondenKnopIngedrukt)
                }
                .filter { it > boatRaceRecord.second }
                .count();
    }
}