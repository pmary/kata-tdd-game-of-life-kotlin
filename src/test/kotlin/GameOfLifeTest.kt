import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CellTest {
    @Test
    fun `Given a cell, When initialized as alive, Then isAlive should return True`() {
        val aliveCell = Cell(CellState.ALIVE)
        assertEquals(aliveCell.isAlive(), true)
    }
}
