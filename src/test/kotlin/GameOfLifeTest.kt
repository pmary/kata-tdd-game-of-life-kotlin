import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CellTest {
    @Test
    fun `Given a cell, When initialized as alive, Then isAlive should return True`() {
        val aliveCell = Cell(CellState.ALIVE)
        assertEquals(aliveCell.isAlive(), true)
    }

    @Test
    fun `Given a cell, When initialized as dead, Then isAlive should return False`() {
        val deadCell = Cell(CellState.DEAD)
        assertEquals(deadCell.isAlive(), false)
    }

    @Test
    fun `Given a cell alive, When it evolve with less than 2 live neighbors, Then it becomes dead`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertEquals(aliveCell.isAlive(), false)
    }

    @Test
    fun `Given a cell alive, When it evolve with more than 3 live neighbors, Then it becomes dead`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertEquals(aliveCell.isAlive(), false)
    }

    @Test
    fun `Given a cell alive, When it evolve with 2 live neighbors, Then it stays alive`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertEquals(aliveCell.isAlive(), true)
    }

    @Test
    fun `Given a cell alive, When it evolve with 3 live neighbors, Then it stays alive`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertEquals(aliveCell.isAlive(), true)
    }

    @Test
    fun `Given a dead cell, When it evolve with exactly 3 live neighbors, Then it becomes alive`() {
        val deadCell = Cell(CellState.DEAD)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        deadCell.evolve(neighbours)
        assertEquals(deadCell.isAlive(), true)
    }
}

class GridTest {
    @Test
    fun `Given a grid, When getNeighbourPositions is called, Then it returns all positions of the neighbours of the cell`() {
        // Given
        val grid = Grid(3, 3)

        // When
        val cellNeighbourPositions = grid.getNeighbourPositions(Position(1, 1), 1)

        // Then
        val expectedNeighbours = setOf(
            Position(0, 0), Position(0, 1), Position(0, 2),
            Position(1, 0), Position(1, 2),
            Position(2, 0), Position(2, 1), Position(2, 2)
        )
        assertEquals(expectedNeighbours.toSet(), cellNeighbourPositions.toSet())
    }
}

class GameTest {
    @Test
    fun `Given a new game, When there is no living cell before the first evolution, Then the game is over`(){
        val grid = Grid(3, 3)
        val game = Game(grid, emptyList<Position>())
        assertEquals(game.isOver(), true)
    }

    @Test
    fun `Given a new game, When there is at lease one living cell, Then the game is not over`(){
        val grid = Grid(3, 3)
        val game = Game(grid, listOf(Position(0,0)))
        assertEquals(game.isOver(), false)
    }

    @Test
    fun`Given a new game, When there is one living cell, Then after the next evolution the game is over`(){
        // Given
        val grid = Grid(3, 3)
        val game = Game(grid, listOf(Position(0,0)))

        // When
        game.play()

        // Then
        assertEquals(game.isOver(), true)
    }
}
