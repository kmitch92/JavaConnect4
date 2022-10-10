public class Player {

  private String name;
  private char token;
  private boolean isComputer;

  public Player(String name, char token, boolean isComputer) {
    this.name = name;
    this.token = token;
    this.isComputer = isComputer;
  }

  public String getName() {
    return name;
  }

  public char getToken() {
    return token;
  }

  public boolean getIsComputer() {
    return isComputer;
  }

}