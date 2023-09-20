import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

enum class CellState {
    ALIVE, DEAD
}
class Cell(private var cellState: CellState) {
    private var state = cellState

    fun isAlive(): Boolean {
        return false
    }
}