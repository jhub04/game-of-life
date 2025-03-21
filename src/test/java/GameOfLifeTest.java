import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

  @Test
  public void testAllDeadCellsStayDead() {
    int[][] input = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    int[][] expected = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    assertArrayEquals(expected, GameOfLife.nextBoardState(input));
  }

  @Test
  public void testDeadCellWithThreeLiveNeighborsBecomesAlive() {
    int[][] input = {
        {0, 0, 1},
        {0, 1, 1},
        {0, 0, 0}
    };

    int[][] expected = {
        {0, 1, 1},
        {0, 1, 1}, // Center becomes alive
        {0, 0, 0}
    };

    assertArrayEquals(expected, GameOfLife.nextBoardState(input));
  }
}
