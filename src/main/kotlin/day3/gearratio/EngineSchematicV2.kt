package day3.gearratio

typealias PartNumber = Int
typealias RangeCoordinate = Pair<IntRange, Int>

class EngineSchematicV2(document: String) {

    val lines: List<String>
    val numbers: List<Pair<RangeCoordinate, PartNumber>>
    val gears: List<RangeCoordinate>

    init {
        lines = document.lines()
        numbers = parseNumbers()
        gears = parseGears()
    }

    private fun parseNumbers(): List<Pair<RangeCoordinate, PartNumber>> {
        return lines.flatMapIndexed { indexY, line ->
            findAllNumbers(line)
                .filter { number -> hasNeighbouringSymbol(number.range, indexY) }
                .map { (it.range to indexY) to it.value.toInt() }
        }
    }

    private fun parseGears(): List<RangeCoordinate> {
        return lines.flatMapIndexed { indexY, line ->
            findAllGears(line)
                .map { it.range to indexY }
        }
    }

    val allNumbers: Int
        get() = numbers.sumOf { it.second };

    val gearRatios: Int
        get() = gears.map { gear ->
            numbers.filter { number -> gear.second -1 <= number.first.second && number.first.second <= gear.second +1}
            numbers.filter { number ->
                number.first.getAdjacentCells().any { it.first == gear.first.first && it.second == gear.second }
            }.toList()
        }.filter { it.size > 1 }
            .map { list -> list.fold(1) { acc, b -> acc * b.second } }
            .sum()


    private fun findAllNumbers(line: String) = Regex("\\d+").findAll(line)
    private fun findAllGears(line: String) = Regex("\\*").findAll(line)

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
    return !(this.isLetterOrDigit() || this.toString() == ".")
}

private fun RangeCoordinate.getAdjacentCells(): List<Pair<Int, Int>> {
    return (this.first.first - 1..this.first.last + 1)
        .flatMap { x ->
            (this.second - 1..this.second + 1)
                .map { y -> x to y }
        }
}