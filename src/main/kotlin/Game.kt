class Game {
    constructor(
        grid: Grid,
        aliveCell: List<Position>
    ) {
        this.grid = grid
        this.aliveCell = aliveCell
    }

    private val grid: Grid
    private var aliveCell: List<Position>

    fun isOver() : Boolean {
        return aliveCell.isEmpty()
    }

    fun play(){
        val aliveCellPositionForCurrentTurn : MutableList<Position> = mutableListOf()
        while(grid.hasNext()){
            val position = grid.next()
            val neighbour = grid.getNeighbourPositions(position,1).map { p -> getCellStateAtPosition(p)}
            val cell = getCellStateAtPosition(position)
            cell.evolve(neighbour)
            if(cell.isAlive()){
                aliveCellPositionForCurrentTurn.add(position)
            }
        }
        aliveCell = aliveCellPositionForCurrentTurn
        grid.reset()
    }

    fun getCellStateAtPosition(position: Position): Cell{
        if(aliveCell.contains(position)){
            return Cell(CellState.ALIVE)
        } else {
            return Cell(CellState.DEAD)
        }
    }
}