import java.io.Serializable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Board that knows the most of the chess game.
 * 
 * @author Antonio Cao Shen
 * @version 1.0
 */
public class Board extends GridPane implements Serializable {

    //size of board 8x8
    private static final int SIZE = 8;
    
    //needed Game to save the chessgame on the board
    private Game game;
    // 2D square array that gets the piece unicode
    private Square[][] square;
    // 2D button array help swap button in MoveTo method
    public Ownbutton[][] buttonData;
    // player, either 0 or 1, taking turns
    private int player;
    //check if a piece is being selected
    private boolean pSelected;

    /**
     * board constructor that assigns both 2D array to 8x8.
     */
    public Board(Game g) {
        game = g;
        square = new Square[SIZE][SIZE]; //square array to display and move
        buttonData = new Ownbutton[SIZE][SIZE]; //button array to help moveTo method
        player = 0; //default player = 0; white's turn first 

        // hard code the original position of the pieces when game start
        placePieces();

        // creating a button with the Ownbutton class
        Ownbutton button;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                button = new Ownbutton(square[col][row], 
                        square[col][row].getPieceID());
                buttonData[col][row] = button;

                // set button to white / grey
                if ((row + col) % 2 == 0) {
                    button.setColor("white");
                } else {
                    button.setColor("grey");
                }

            }
        }
        // adding all buttons
        addButtons();
    }

    // physicall add all the buttons to help Serializability,
    // because GridPane does not implements Serializable.
    public void addButtons() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Ownbutton button = buttonData[col][row];
             // setting button to size 600,600
                button.setPrefSize(600, 600);
                button.paint();
                button.setText(square[col][row].getPieceID());
                addListener(button);
                add(button, col, row);          
            }
        }
    }

    // calling the Addlistener class to react on user's click
    public void addListener(Ownbutton s) {
        s.addEventHandler(MouseEvent.MOUSE_CLICKED, new AddListener(s, this));
    }

    // method that set the original location of the pieces when game first start
    public void placePieces() {
        // for loops set everything to null
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new Square(i, j, null);
            }
        }
        
        // hard coding location of the pieces
        square[0][0] = new Square(0, 0, new Rook(1));
        square[1][0] = new Square(1, 0, new Knight(1));
        square[2][0] = new Square(2, 0, new Bishop(1));
        square[3][0] = new Square(3, 0, new Queen(1));
        square[4][0] = new Square(4, 0, new King(1));
        square[5][0] = new Square(5, 0, new Bishop(1));
        square[6][0] = new Square(6, 0, new Knight(1));
        square[7][0] = new Square(7, 0, new Rook(1));
        square[0][7] = new Square(0, 7, new Rook(0));
        square[1][7] = new Square(1, 7, new Knight(0));
        square[2][7] = new Square(2, 7, new Bishop(0));
        square[3][7] = new Square(3, 7, new Queen(0));
        square[4][7] = new Square(4, 7, new King(0));
        square[5][7] = new Square(5, 7, new Bishop(0));
        square[6][7] = new Square(6, 7, new Knight(0));
        square[7][7] = new Square(7, 7, new Rook(0));

        // used for loop for the pawns on row 1 and 6 since they are the same
        for (int a = 0; a < square.length; a++) {
            square[a][1] = new Square(a, 1, new Pawn("\u265F", "abc", 1));
            square[a][6] = new Square(a, 6, new Pawn("\u2659", "abc", 0));
        }
    }

    // checker method that checks if square has a piece
    public boolean checker(int x, int y) {
        if (square[x][y].getPiece() == null) {
            pSelected = false; //if empty then no piece
            return false;
        }
        //other wise there is a piece
        pSelected = true;
        return true;
        // return (square[x][y].getPiece()!= null);
    }

    /**
     * method that takes previous x/y and new x/y so the method can swap the buttons
     * and erase the unicode piece on the first button and print the unicode piece
     * on the second button.
     */
    public void moveTo(int prevx, int prevy, int x, int y) {
        //set the new square to old square's pieceID
        square[x][y].setPiece(square[prevx][prevy].getPiece());
        //after done setting it, set old piece to null
        square[prevx][prevy].setPiece(null);
        //after done setting, set old buttonData to empty string
        buttonData[prevx][prevy].setText("");
        //moved square == moved buttonData
        buttonData[x][y].setText(square[x][y].getPieceID());

        //after a move, switch player and take turns
        if (player == 0) {
            player = 1;
        } else {
            player = 0;
        }

    }

    //get if there is a pselected to help listener class
    public boolean getPSelected() {
        return pSelected;
    }

    //method that can setPselected to false, after moved in listener class
    public void setPSelected(boolean x) {
        pSelected = x;
    }

    // method that check if piece selecting is mines
    public boolean isMyPiece(int x, int y) {
        //if empty, false
        if (square[x][y].getPiece() == null) {
            return false; 
        }
        //true if color of piece belongs to current player
        return square[x][y].getPiece().getColor() == player;
    }

    // method that get the color accroding to it's cordinates
    public int getColor(int x, int y) {
        //if empty return -1
        if (square[x][y].getPiece() == null) {
            return -1;
        }
        
        return square[x][y].getPiece().getColor();
    }

    //getPlayer method that helps to Listener class to 
    //determine who's player's turn
    public int getPlayer() {
        return this.player;
    }

    //getPiece method that get a piece according 
    //to its x and y cordinates
    public Pieces getPiece(int x, int y) {
        return square[x][y].getPiece();
    }

    //since the board knows the most, isPathClear for the Piece is best 
    //located inside the board.
    public boolean isPathClear(int x, int y, int dirx, int diry, int dis) {
        
        //loop through the path using the newx,y and oldx,y to check 
        //if there is a piece blocking it's path.
        for (int i = 1; i < dis; i++) {
            if (square[x + i * dirx][y + i * diry].getPiece() != null) {
                return false;
            }
        }
        
        //if newx,y contains enermy's piece, return true to attack
        return (getColor(x + dis * dirx, y + dis * diry) != player);

    }

    //method that save everything on this board, when save button 
    //is pressed.
    public void saveGame() {
        game.saveGame();
    }

}
