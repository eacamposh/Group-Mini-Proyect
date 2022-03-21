public class Bishop extends Piece {

  public Bishop(boolean white) {

    super(white);
  }

  @Override
  public boolean isValidMove(Move move) {
    if (!super.isValidMove(move)) {
      return false;
    }
    if (move.getEndPosition().getPiece() != null) {
      if (move.getEndPosition().getPiece().isWhite() == move.getStartPosition().getPiece()
          .isWhite()) {
        return false;
      }
    }
    boolean aux= thereIsAPieceOnMyWay(move);
    if (Math.abs(move.getEndPosition().getCol() - move.getStartPosition().getCol()) ==
        Math.abs(move.getEndPosition().getRow() - move.getStartPosition().getRow())&& aux) {
      return true;
    } else {
      return false;
    }
  }

  public boolean thereIsAPieceOnMyWay(Move move) {

    int rowOffset, colOffset;
    int currentRow= move.getStartPosition().getRow();
    int newRow= move.getEndPosition().getRow();
    if(currentRow < newRow){
      rowOffset = 1;
    }else{
      rowOffset = -1;
    }
    int currentCol= move.getStartPosition().getCol();
    int newCol= move.getEndPosition().getCol();
    if(currentCol < newCol){
      colOffset = 1;
    }else{
      colOffset = -1;
    }

    Position pos[][] = move.getGame().getBoard();
    int y = currentRow + rowOffset;
    for(int x = currentCol + colOffset; x != newCol; x += colOffset){

      if(pos[y][x].getPiece() != null){
        return false;
      }

      y += rowOffset;
    }

    return true;
  }

  @Override
  public String toString() {
    if (isWhite()) {
      return "♗";
    } else {
      return "♝";
    }
  }


}

