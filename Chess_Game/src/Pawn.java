/**
 * Pawn IS A Piece, therefore extends abstract class named Pieces, this
 * contains Pawn's unicode to display on the board and boolean check if the
 * spot its moving to is valid accoring to it's own move.
 * 
 * @version 1.0
 * @author Antonio Cao Shen
 */
public class Pawn extends Pieces {

    // private boolean checkc if it's Pawn's first move
    private boolean first = true;
    // since the direction of the pawns can be different based on
    // its color or player
    private int direction;

    // constructor that accepts pieceID, piece path and player
    public Pawn(String id, String path, int color) {
        // sets the abstract method to this id in the parameter
        setId(id);
        // sets the path of pawn which accpeted inside the parameter
        setPath(path);
        // sets the color of the Pawn
        setColor(color);
        direction = -1 + (2 * color);
    }

    /**
     * Pawn extends abstract class Pieces, Pawn overrided the 
     * isValidMove of the Pieces class to it's own its own unique 
     * isValidMove. Parameter stayed the same, still accepts
     * oldx,y newx,y and a board since the board knows the most.
     */
    
    @Override
    public boolean isValidMove(
            int oldx, int oldy, int newx, int newy, Board board) {

        //if it's not my own piece
        if (board.getColor(newx, newy) != this.getColor()) {
            //if square moving to is empty
            if (board.getColor(newx, newy) == -1) {
                //if it's pawn's first move, then it can move either 1 or 2
                if (first && oldx == newx && (newy - oldy) == 2 * direction
                        && board.getColor(newx, oldy + direction) == -1) {
                    //after moved, no longer first, so set first to false
                    first = false;
                    return true;
                } else {
                    //move by one on the same col
                    if ((oldx == newx && (newy - oldy) == 1 * direction)) {
                        //after moved, set first to false
                        first = false;
                        return true;
                    }
                }
            } else {
                // attacking, it can only attack diagontally 
                // if there's an enemy piece
                if (Math.abs(newx - oldx) == 1 
                        && ((newy - oldy) == 1 * direction)) {
                    first = false;
                    return true;
                }
            }
        }
        
        //otherwise return false
        return false;
    }

}
