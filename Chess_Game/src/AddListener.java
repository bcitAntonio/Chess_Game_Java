import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Listener class, react to the board when user click on the squrae by moving/
 * checkcing if pieces are movable.
 * 
 * @author Antonio Cao Shen
 * @version 1.0
 */
public class AddListener implements EventHandler<MouseEvent> {

    /** static x keeps track of the old x-cord after the first click. */
    private static int x;

    /** static y keeps track of the old y-cord after the first click. */
    private static int y;

    /**
     * creating a Ownbutton object so i can get the current square and then get the
     * x when clicked on.
     */
    private Ownbutton b;

    /**
     * creating a board object so i can call the checker method and check if a piece
     * is moviable.
     */
    private Board board;
    

    // private boolean pSelected;
    /**
     * Listener class that listen to the board when user clicked on.
     * 
     * @param b
     *            own button created that has a method to get the square
     * @param board
     *            refernece and i can call the board to move the pieces.
     */
    public AddListener(Ownbutton b, Board board) {
        this.b = b;
        this.board = board;
        x = -1;
        y = -1;
    }

    /**
     * method that get the current x/y and sets the previous x/y by working with
     * MouseEvent Listener.
     * 
     * @param event
     *            MouseEvent Listener
     */
    public void handle(MouseEvent event) {

        // gets the current x by using the button to get the square and getX
        int x1 = b.getSquare().getX();

        // gets the current y by using the button to get the square and getY
        int y1 = b.getSquare().getY();

        //is there  a piece selected
        if (board.getPSelected()) {
            //when trying to move peice to its original spot = deselect
            if (x == x1 && y == y1) {
                board.setPSelected(false); //set to deselect 
            //if it's player's turn 
            } else if (board.getColor(x1, y1) == board.getPlayer()) {
                x = x1;
                y = y1;
            //if move is vliad the calling board's move method to move the piece
            } else if (board.getPiece(x, y).isValidMove(x, y, x1, y1, board)) {
                board.moveTo(x, y, x1, y1);
                board.setPSelected(false); //after moved set Pselected to false
                
            //otherwise it's invalid move
            } else {
                System.out.println("invalid move");
            }
        
            //if the piece that i am selecting is mines
        } else {
            if (board.isMyPiece(x1, y1)) {
                //i am selecting a piece
                board.setPSelected(true);
                //assign new cordinates to x cordinates
                x = x1;
                y = y1;
            }
        }
    }

}
