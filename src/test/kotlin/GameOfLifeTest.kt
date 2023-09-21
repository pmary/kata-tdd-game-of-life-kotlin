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
