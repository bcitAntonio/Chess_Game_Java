import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Game implements Serializable{
    
    //initalize a board to help save/load game method
    public Board board;
    
    //static method that creates a game according to the board
    public static Game newGame() {
        Game game = new Game();
        game.board = new Board(game);
        return game;
    }
    

    // method that save the board of the game inside a ser extension file
    // throws an exception if IOException if can not read one
    public void saveGame() {
        try {
            FileOutputStream fileOut =
            new FileOutputStream("Game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this); //writeobject
            out.close(); //after write, close
            fileOut.close();
            //if it's being serilized print to comfirm 
            System.out.printf("Serialized data is saved in Game.ser");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }
    
    // method that load the board of the game from a ser extension file
    // throws an exception if IOException if can not read one
    public static Game loadGame() {
        Game game = null;
        try {
            FileInputStream fileIn = new FileInputStream("Game.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            game = (Game) in.readObject(); //read
            in.close(); //after reading close
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
         } catch (ClassNotFoundException c) {
             //if can not load one, print game class not found to user
            System.out.println("Game class not found");
            c.printStackTrace();
         }
        //adding the oldboard to the game
        game.board.addButtons();
        return game;
    }
    
    

}
