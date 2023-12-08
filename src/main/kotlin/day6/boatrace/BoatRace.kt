package day6.boatrace

typealias Time = Long
typealias Distance = Long

class BoatRace(input: String) {

    val boatRaceRecords: List<Pair<Time, Distance>>;

    init {
        val timeAndDistanceSeparateList = input.lines().map {
            it.split(" ")
                .filter { it.isNotBlank() && it.get(0).isDigit() }
                .map { it.toLong() }
                .toList()
        }.toList()
        boatRaceRecords = timeAndDistanceSeparateList.get(0).zip(timeAndDistanceSeparateList.get(1))
    }

    fun getMarginError(): Int {
        return boatRaceRecords.map { boatRace ->
            LongRange(0, boatRace.first)
                .map { aantalSecondenKnopIngedrukt ->
                    aantalSecondenKnopIngedrukt * (boatRace.first - aantalSecondenKnopIngedrukt)
                }
                .filter { it > boatRace.second }
                .count()
        }.reduce { a, b -> a * b }
    }
}