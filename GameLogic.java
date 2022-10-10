public interface GameLogic {

  // A generalised version of the horizontal check present in the legacy code, now accepting the board and player token as arguments.

  default boolean checkHorizontal(char[][] board, char token) {
    boolean result = false;
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == token) {
          count = count + 1;
          if (count >= 4) {
            result = true;
          }
        } else {
          count = 0;
        }
      }
    }
    return result;
  }
  
  default boolean checkVertical(char[][] board, char token) {
    boolean result = false;
    int count = 0;
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == token) {
          count = count + 1;
          if (count >= 4) {
            result = true;
          }
        } else {
          count = 0;
        }
      }

    }
    return result;
  }
  
 default boolean checkFallingDiagonal(char[][] board, char token) {
    boolean result = false;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == token) {
          if (board[i + 1][j + 1] == token &&
              board[i + 2][j + 2] == token &&
              board[i + 3][j + 3] == token) {
            result = true;
            break;
          }
        }
      }
    }
    return result;
  }
  
  default boolean checkRisingDiagonal(char[][] board, char token) {
    boolean result = false;
    for (int i = board.length - 1; i > 2; i--) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == token) {
          if (board[i - 1][j + 1] == token &&
              board[i - 2][j + 2] == token &&
              board[i - 3][j + 3] == token) {
            result = true;
            break;
          }
        }
      }
    }
    return result;
  }
  
  default boolean checkDraw(char[][] board) {
    boolean drawn;
    for (int i = 0; i < board[0].length; i++) {
      if (!Character.isLetter(board[0][i])) {
        drawn = false;
        return drawn;
      }
    }
    drawn = true;
    return drawn;
  }
  
  default boolean checkFullColumn(char[][] board, int col) {
    boolean isFull = false;
    if (board[0][col - 1] != 0) {
      isFull = true;
    }
    return isFull;
  }
  
  default int getComputerMove(char[][] board) {
    int move = 1 + (int)(Math.random() * board[0].length);
    return move;
  }
}