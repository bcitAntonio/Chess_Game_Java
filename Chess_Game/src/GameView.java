import java.io.Serializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * GameView that contains the save, load, and new button 
 * where user can save, and load back old game by clicking 
 * the button. This class also contains the main method 
 * that drives the program in this chess game.
 * @version 1.0
 * @author Antonio Cao Shen
  */
public class GameView extends Application implements Serializable {
    
    // we need a Game because Game has serializable 
    // method for save and load game
    private Game game;
    
    //initalizing button to save the game
    private Button save; 
    
    //initalizing button to load the game
    private Button load;
    
    //initalizing button to create a new game
    private Button newGame;
    
    //we need to put the game and save/load/new button together
    private GridPane pane;
    
    //putting save/load/new buttons together on the top left corner
    private GridPane buttonPane;
    
    
    public void  start(Stage primaryStage) throws Exception{
        
        //assigning newgame method in Game to game variable
        game = Game.newGame();
        //creaing a new gridpane to display everything
        pane = new GridPane();
        //creating buttonPane to display buttons together
        buttonPane = new GridPane();
        //create a save button
        save = new Button("Save");
        //create a load button
        load = new Button("load");
        //create a new button
        newGame = new Button("new");
        
        //adding save/load/new to the button pane
        buttonPane.add(save,1,0);
        buttonPane.add(load,2,0);
        buttonPane.add(newGame, 0,0);
        //adding buttonspane, and the game to the final pane
        pane.add(buttonPane,0,0);
        pane.add(game.board, 0,1);
        //calling the button listener method for 
        //save/new/load buttons
        buttonListner();
        
        
        //setting window size to 600 x 600
        primaryStage.setScene(new Scene(pane,600, 600));
        primaryStage.show();
    }
    
    private void buttonListner() {
        //save a game
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.saveGame();
            }
        }); 
        
        //load a game
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //get the children of the pane and remove the board
                pane.getChildren().remove(game.board);
                //then load the old game
                game = Game.loadGame();
                //adding the newgame to the pane to display
                pane.add(game.board, 0,1);
            }
        }); 
        
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //get the children of the pane and remove from the board
                pane.getChildren().remove(game.board);
                //create a new game
                game = Game.newGame();
                //adding the newgame to the pane to display
                pane.add(game.board, 0,1);
            }
        }); 
    }
    
    
    
    /**
     * drives the program.
     * @param args launch the args
     */
    public static void main(String[] args) {
        //System.out.println(Math.signum(-5));
        launch(args);
    }
    
}

