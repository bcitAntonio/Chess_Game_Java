
/**
 * King IS A Piece, therefore extends abstract class named Pieces, this contains
 * King's unicode to display on the board and boolean check if the spot its
 * moving to is valid accoring to it's own move.
 * 
 * @author Antonio Cao Shen
 * @version 1.0
 */

public class King extends Pieces {

    /**
     * constructor for the King that accepting a color, 
     * either 0 or 1. if Color is 0
     * then it's white, if it's 1 then it's black.
     * 
     * @param color
     *            Color of the King
     */
    public King(int color) {

        // switch statement for Color
        switch (color) {

        // if color is 0
        case 0:
            // set the King to White
            setId("\u2654");
            break;

        // if color is 1
        case 1:
            // set the King to Black
            setId("\u265A");
            break;

        // default for the switch statement
        // code should not get here
        default:
            break;
        }
        setColor(color);
    }

    /**
     * King extends abstract class Pieces, King overrided the 
     * isValidMove of the Pieces class to it's own its own unique 
     * isValidMove. Parameter stayed the same, still accepts
     * oldx,y newx,y and a board since the board knows the most.
     */
    @Override
    public boolean isValidMove(
        int oldx, int oldy, int newx, int newy, Board board) {
        // King can only move by one square in any direction, therefore
        // if the absolute value of newx - oldx is less or equal to 1 and 
        // absolute value of newy - oldy is equal to less than or equal to 1
        return (Math.abs(newx - oldx) <= 1) && (Math.abs(newy - oldy) <= 1);
    }
}
