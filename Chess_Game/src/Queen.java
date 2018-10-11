/**
 * Queen IS A Piece, therefore extends abstract class named Pieces, this
 * contains Queen's unicode to display on the board and boolean check if the
 * spot its moving to is valid accoring to it's own move.
 * @version 1.0
 * @author Antonio Cao Shen
 */

public class Queen extends Pieces {
    
    /**
     * constructor for the Queen that accepting a color, 
     * either 0 or 1. if Color is 0
     * then it's white, if it's 1 then it's black.
     * 
     * @param color
     *            Color of the Queen
     */
    
    public Queen(int color) {
          
        //swith cases to determine color of Queen
          switch (color) {
          //if 0, set white Queen
          case 0:
              setId("\u2655");
              break;
          // 1, set Black Queen
          case 1:
              setId("\u265B");
              break;
          
          default: break; //code should not get here
          
          }
          setColor(color);
      }
    
    /**
     * Queen extends abstract class Pieces, Queen overrided the 
     * isValidMove of the Pieces class to it's own its own unique 
     * isValidMove. Parameter stayed the same, still accepts
     * oldx,y newx,y and a board since the board knows the most.
     */
    @Override
    public boolean isValidMove(
            int oldx, int oldy, int newx, int newy, Board board) {
        // since queen moves in a combination of rook and bishop, 
        // this if statement is the combination of the two.
        if (newx == oldx || newy == oldy 
             || (Math.abs(newx - oldx) == Math.abs(newy - oldy))) {
            //return true if path of the moving to square is clear
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
