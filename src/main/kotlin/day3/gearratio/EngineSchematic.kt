package day3.gearratio

class EngineSchematic(document: String) {

    val lines: List<String>

    init {
        lines = document.lines()
    }

    val allNumbers: Int
        get() =
            lines.flatMapIndexed { index_Y, line ->
                findAllNumbers(line)
                    .filter { number -> hasNeighbouringSymbol(number.range, index_Y) }
                    .map { it.value.toInt() }
            }.sum();


    private fun findAllNumbers(line: String) = Regex("\\d+").findAll(line)

    private fun hasNeighbouringSymbol(indexX: IntRange, indexY: Int): Boolean {
        (getLowerBound(indexY)..getUpperBound(indexY, lines.size)).forEach { y ->
            (getLowerBound(indexX.first)..getUpperBound(indexX.last, lines.get(y).length)).forEach { x ->
                if (lines.get(y).get(x).isSymbol()) {
                    return true
                }
            }
        }
        return false;
    }

    private fun getLowerBound(index: Int) = if (index == 0) 0 else index - 1
    private fun getUpperBound(index: Int, size: Int) = if (index == size - 1) index else index + 1
}

private fun Char.isSymbol(): Boolean {
    return !(this.isLetterOrDigit() || this.toString().equals("."))
}
