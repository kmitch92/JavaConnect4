import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO {

  private BufferedReader input;

  public IO() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  public void startMessages() {
    System.out.println("Welcome to Connect 4");
    System.out.println("There are 2 players red and yellow");
    System.out.println("Player 1 is Red, Player 2 is Yellow");
    System.out.println("To play the game type in the number of the column you want to drop you counter in");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
    System.out.println("");
  }

  public int getUserInput() {

    String stringInput;
    int parsedInput = 0;

    System.out.println("Where would you like to place your token?");
    while (parsedInput < 1 || parsedInput > 7) {
      try {
        System.out.println("Please enter a number between 1 and 7.");
        stringInput = input.readLine();
        parsedInput = Integer.parseInt(stringInput);
      } catch (Exception e) {
        System.out.println("Please enter a valid column number.");
      }
    }
    return parsedInput;
  }
  
  public void sendFinishMessage(boolean win, String winner) {
    if (win) {
      System.out.println("Congratulations " + winner + "! You won!");
    } else {
      System.out.println("The game was a draw. At least nobody lost.");
    }
  }
}