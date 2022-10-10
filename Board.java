public class Board{
  
  public char[][] board;
  
public Board(){
  board = new char[6][7];
}

public void printBoard() {
  char token;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          token = board[i][j];
          System.out.print("| " + token + " ");
        } else {
          System.out.print("|   ");
        }
      }
      System.out.println("|");
    }
    int count = 1;
   while(count<=board[0].length){
    System.out.print("  " + count + " ");
     count++;
     }
  System.out.println();
  }
  
public void placeCounter(char token, int position) {
    boolean placed = false;
    while(!placed){
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (Character.isLetter(board[i][position - 1])) {
            continue;
          } else {
            board[i][position - 1] = token;
            placed = true;
          }
        }
      }
    }
  }
   
}