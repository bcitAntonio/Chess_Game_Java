/**
 * Rook IS A Piece, therefore extends abstract class named Pieces, this
 * contains Rook's unicode to display on the board and boolean check if the
 * spot its moving to is valid accoring to it's own move.
 * @version 1.0
 * @author Antonio Cao Shen
 */

public class Rook extends Pieces {
    
    /**
     * constructor for the Rook that accepting a color, 
     * either 0 or 1. if Color is 0
     * then it's white, if it's 1 then it's black.
     * 
     * @param color
     *            Color of the Rook
     */
    
    public Rook(int color) {
        // switch case to determine color of Rook
          switch (color) {
          // if color is 0, Rook is white
          case 0:
              setId("\u2656"); //unicode for white Rook
              break;
          // if color is 1, Rook is Black
          case 1:
              setId("\u265C"); //unicode for black rook
              break;
          
          default: break; //code should not get here.
          
          }
          setColor(color);
      }

    /**
     * Rook extends abstract class Pieces, Rook overrided the 
     * isValidMove of the Pieces class to it's own its own unique 
     * isValidMove. Parameter stayed the same, still accepts
     * oldx,y newx,y and a board since the board knows the most.
     */
    @Override
    public boolean isValidMove(
            int oldx, int oldy, int newx, int newy, Board board) {
        // Rook can only move vertical or horizontal
        if (newx == oldx || newy == oldy) {
            //return true if path is clear
            return board.isPathClear(oldx, oldy, 
                    (int) Math.signum(newx - oldx), 
                    (int) Math.signum(newy - oldy), 
                    Math.max(Math.abs(newx - oldx), 
                    Math.abs(newy - oldy)));
        }
        //otherwise return false
        return false;
    }
}
