/**
 * Bishop IS A Piece, therefore extends abstract class named Pieces, this
 * contains Bishop's unicode to display on the board and boolean check if the
 * spot its moving to is valid accoring to it's own move.
 * 
 * @version 1.0
 * @author Antonio Cao Shen
 */

public class Bishop extends Pieces {

    /**
     * Bishop IS A Pieces, therefore extends abstract class named Pieces.
     * 
     * @param color
     *            determines the player, it can either be 0 or 1.
     */
    public Bishop(int color) {

        // a switch case to determine color of Bishop,
        // 0 is white, 1 is black
        switch (color) {

        // player is white
        case 0:
            // unicode for the white Bishop
            setId("\u2657");
            break;

        // player is black
        case 1:
            // unicode for the black bishop
            setId("\u265D");
            break;

        // default for the switch statement
        // code should not get here
        default:
            break;

        }

        // setColor of the bishop to that color,
        // after knowing it's color from player 1 or 0
        setColor(color);
    }

    /**
     * Bishop extends abstract class Pieces, Bishop 
     * overrided the isValidMove of the Pieces class to 
     * it's own its own unique isValidMove. Parameter 
     * stayed the same, still accepts oldx,y newx,y and 
     * a board since the board knows the most.
     */
    @Override
    public boolean isValidMove(int oldx, int oldy, 
            int newx, int newy, Board board) {

        /**
         * Since the board knows the most, we will 
         * use the isPathClear in the board class to 
         * check if there's anything blocking the path 
         * that the Bishop is moving to . if horizontal 
         * distance is equal to the vertical distance
         * therefore it's moving diagontal.
         **/
        if (Math.abs(newx - oldx) == Math.abs(newy - oldy)) {
            return board.isPathClear(oldx, oldy, 
                    (int) Math.signum(newx - oldx), 
                    (int) Math.signum(newy - oldy),
                    Math.abs(newx - oldx));
        }
        
        return false;
    }

}
