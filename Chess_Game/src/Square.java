import java.io.Serializable;

/**
 * Square class that assigns to each button.
 * @author Antonio Cao Shen
 * @version 1.0
 */
public class Square implements Serializable{

    // square x 
    private int x;
    //square y
    private int y;
    //creating a piece object
    private Pieces p;
    
    /**
     * constructor that accepts x,y and a piece
     * @param x x-cord of the square
     * @param y y-cord of the square
     * @param p piece so class can use getpieceID
     * getPiece and setPiece method.
     */
    public Square (int x, int y, Pieces p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    /**
     * getter gets the x-cord.
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * getter gets the y-cord.
     * @return y 
     */
    public int getY() {
        return y;
    }
    
    // method that gets the pieceID
    public String getPieceID() {
            if(p == null) {
                return "";
            }
            return p.getId();
    }
    
    //method that gets a piece
    public Pieces getPiece() {
        return p;
    }
    
    //method that sets a piece
    public void setPiece(Pieces p1) {
         p = p1;
    }
    
}
