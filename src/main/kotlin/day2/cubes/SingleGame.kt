package day2.cubes

class SingleGame(val gameNumber: Int, val colorMaxAmount: Map<String, List<Int>>) {

    fun isPossible(red: Int, green: Int, blue: Int): Boolean {
        return (getRed(0).max() <= red
                && getGreen(0).max() <= green
                && getBlue(0).max() <= blue)
    }

    val powerOfCubes: Int
        get() {
            return getRed(1).max() * getGreen(1).max() * getBlue(1).max()
        }

    private fun getRed(default: Int) = colorMaxAmount.getOrDefault("red", listOf(default))
    private fun getGreen(default: Int) = colorMaxAmount.getOrDefault("green", listOf(default))
    private fun getBlue(default: Int) = colorMaxAmount.getOrDefault("blue", listOf(default))

}