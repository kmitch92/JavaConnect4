public class Game implements GameLogic {

  public Game() {
    playGame();
  }

  private void playGame() {
    Board b = new Board();
    IO io = new IO();
    Player one = new Player("Player 1", 'r', false);
    Player two = new Player("Player 2", 'y', true);
    Player[] players = {
      one,
      two};

    io.startMessages();
    b.printBoard();
    boolean win = false;
    boolean drawn = false;
    int skip = 0;
    String winner = " ";
    
    while (!win && !drawn) {
      for (Player player: players) {
        drawn = checkDraw(b.board);
        System.out.println();

        if (skip > 0) {
          skip--;
          continue;
        }

        int move;
        if (player.getIsComputer()) {
          move = getComputerMove(b.board);
        } else {
          move = io.getUserInput();
        }

        if (checkFullColumn(b.board, move)) {
          if (!player.getIsComputer()) {
            System.out.println("That column's full, please pick a different one.");
          }
          skip = players.length-1;
          continue;
        }

        b.placeCounter(player.getToken(), move);
        
        if (player.getIsComputer()) {
          System.out.println("My turn! Let me think...");
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
          System.out.println(move);
        }

        b.printBoard();
        if (checkHorizontal(b.board, player.getToken()) ||
            checkVertical(b.board, player.getToken()) ||
            checkRisingDiagonal(b.board, player.getToken()) ||
            checkFallingDiagonal(b.board, player.getToken())
        ) {
          winner = player.getName();
          win = true;
          break;
        }
      }
    }
    io.sendFinishMessage(win, winner);
  }

}
  

