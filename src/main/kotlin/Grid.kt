data class Position(var x: Int, var y: Int)

class Grid(private val rows: Int, private val cols: Int) {
    fun getNeighbourPositions(position: Position, scale: Int): Set<Position> {
        val neighbourPositions = mutableSetOf<Position>()

        return neighbourPositions
    }
}