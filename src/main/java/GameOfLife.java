import java.util.Random;

public class GameOfLife {

  public static int[][] generateDeadState(int width, int height) {
    int[][] state = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        state[i][j] = 0;
      }
    }
    return state;
  }

  public static int[][] generateRandomState(int width, int height) {
    int[][] state = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Random random = new Random();
        int randomValue = random.nextInt(2);
        state[i][j] = randomValue;
      }
    }
    return state;
  }

  public static void render(int[][] state) {
    StringBuilder sb = new StringBuilder();
    for (int[] row : state) {
      for (int i = 0; i < row.length; i++) {
        sb.append(row[i]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static int findLiveNeighbors(int[][] state, int rowIndex, int colIndex) {
    int liveNeighbors = 0;
    int[][] neighborOffsets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    for (int[] neighborOffset : neighborOffsets) {
      int newRowIndex = rowIndex + neighborOffset[0];
      int newColIndex = colIndex + neighborOffset[1];

      if (newRowIndex >= 0 && newRowIndex <= state.length - 1) {
        if (newColIndex >= 0 && newColIndex <= state[0].length - 1) {
          if (state[newRowIndex][newColIndex] == 1) {
            liveNeighbors++;
          }
        }
      }
    }

    return liveNeighbors;
  }

  public static int[][] nextBoardState(int[][] state) {
    int[][] nextState = new int[state.length][state[0].length];
    // Iterate over the board
    for (int row = 0; row<state.length; row++) {
      for (int col = 0; col<state[0].length; col++) {
        // Find the neighbors of the cell
        int liveNeighbors = findLiveNeighbors(state, row, col);
        boolean isLive = state[row][col] == 1 ? true : false;
        // Any live cell with 0 or 1 or more than 3 live neighbors becomes dead
        if (isLive && liveNeighbors <= 1 || liveNeighbors > 6) {
          nextState[row][col] = 0;
        }
        // Any dead cell with exactly 3 live neighbors becomes alive
        else if (!isLive && liveNeighbors == 3) {
          nextState[row][col] = 1;
        }

        else {
          nextState[row][col] = state[row][col];
        }
      }
    }

    return nextState;
  }

  public static void main(String[] args) {
    int[][] randomState = generateRandomState(4, 4);
    render(randomState);
    System.out.println();
    int[][] nextState = nextBoardState(randomState);
    render(nextState);

  }
}
