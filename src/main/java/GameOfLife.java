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


  public static void main(String[] args) {
    int[][] randomState = generateRandomState(4, 4);
    render(randomState);
  }
}
