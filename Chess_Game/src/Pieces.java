import java.io.Serializable;

/**
 * Pieces abstract class that all 
 * character pieces extends this class.
 * @author Antonio Cao Shen
 * @version 1.0
 */
public abstract class Pieces implements Serializable{
    
    
    // color of the player
    private int color;
    
    //unicode of the piece
    private String id;
    
    //each piece has a path
    private String path;

    //getter to get the piece color
    public int getColor() {
        return color;
    }
    
    //setter to set the piece color
    public void setColor(int color) {
        this.color = color;
    }

    //method that gets the id of the piece
    public String getId() {
        return id;
    }
   
    //method that sets the id of the piece
    public void setId(String id) {
        this.id = id;
    }

    //method that gets the path of the piece
    public String getPath() {
        return path;
    }
    
    //method that sets the path of the piece
    public void setPath(String path) {
        this.path = path;
    }   

    /**since each piece should have its own unique isValidMove
     *here the abstract method accepts an oldx,y, newx,y and board
     *in the piece abstract class.
     */
    public boolean isValidMove(
            int oldx, int oldy, int newx, int newy, Board board) {
        return true;
    }
    
}
