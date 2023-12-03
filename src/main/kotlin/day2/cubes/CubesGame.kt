package day2.cubes

class CubesGame(gamesString: List<String>) {
    val games: List<SingleGame>;

    init {
        games = ArrayList()
        gamesString.forEach {
            val gameNumber = parseGameNumber(it)
            parseColorCubes(it, games, gameNumber)
        }
    }

    private fun parseColorCubes(
        it: String,
        games: ArrayList<SingleGame>,
        gameNumber: Int
    ) {
        val gamesAsString = it.split(": ").get(1).split("; ")
        val colorMaxAmount = HashMap<String, ArrayList<Int>>()
        gamesAsString.flatMap {
            it.split(", ").map { it.split(" ").get(0).toInt() to it.split(" ").get(1) }
        }.forEach {
            val new = colorMaxAmount.getOrDefault(it.second, ArrayList())
            new.add(it.first)
            colorMaxAmount.put(it.second, new)
        }
        games.add(SingleGame(gameNumber, colorMaxAmount))
    }

    private fun parseGameNumber(it: String): Int {
        return it.split(":").get(0).replace("Game ", "").toInt()
    }

    fun sumPossibleGames(red: Int, green: Int, blue: Int): Int {
        return games.filter { it.isPossible(red, green, blue) }
            .map { it.gameNumber }
            .sum()
    }

    fun sumPowerOfGames(): Int {
        return games.map { it.powerOfCubes }.sum()
    }
}