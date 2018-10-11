/**
 * Knight IS A Piece, therefore extends abstract class named Pieces, this
 * contains Knight's unicode to display on the board and boolean check if the
 * spot its moving to is valid accoring to it's own move.
 * 
 * @version 1.0
 * @author Antonio Cao Shen
 */
public class Knight extends Pieces {
    
    /**
     * constructor for the Knight that accepting a color, 
     * either 0 or 1. if Color is 0
     * then it's white, if it's 1 then it's black.
     * 
     * @param color
     *            Color of the Knight
     */
    public Knight(int color) {
        // switch statement for Color
          switch(color) {
          
          //if color is 0
          case 0:
              //set Piece Id to white Knight
              setId("\u2658");
              break;
              
          //if color is 1
          case 1:
              //set Piece Id to Black Knight
              setId("\u265E");
              break;
          
          default: break; //code should not get here
          }
          
          //set Piece color to either white or black
          setColor(color);
      }
    
    /**
     * Knight extends abstract class Pieces, Knight overrided the 
     * isValidMove of the Pieces class to it's own its own unique 
     * isValidMove. Parameter stayed the same, still accepts
     * oldx,y newx,y and a board since the board knows the most.
     */
    @Override
    public boolean isValidMove(
            int oldx, int oldy, int newx, int newy, Board board) {
        
        //array that keeps track of possible move of x values for Knight
        int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
        
        //array that keeps track of possible move of y values for Knight
        int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };

        if (newx >= 0 && newy >= 0) {
            for (int i = 0; i < row.length; i++) {
                if ((oldx + row[i]) == newx && (oldy + col[i] == newy)) {
                    return true;
                }
            }
        }
        return false;
    }
}
