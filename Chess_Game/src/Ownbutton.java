
import java.io.Serializable;

import javafx.scene.control.Button;

/**
 * Ownbutton class that have less limit than the application 
 * button class.
 * @author Antonio Cao Shen
 * @version 1.0
 */
public class Ownbutton extends Button implements Serializable {
    
    private String color = "red";
    
    // creating square object named square
    private Square square;
    
    //first constructor that accepts only a square
    public Ownbutton(Square square) {
        this.square = square;
    }
    
    //overloading the constructor that accepts square and piece id
    public Ownbutton(Square square, String id) {
        super(id);
        this.square = square;
    }
    
    //method that set the color 
    public void setColor(String color) {
        this.color = color;
    }
    
    //avoid gridpane for serializability
    public void paint() {
        //setText(id);
        setStyle("-fx-background-color: " + color + ";" + "-fx-font: 30 arial;");
    }
    
    /**
     * method that get shte square by the button.
     * @return the square
     */
    public Square getSquare() {
        return square;
    }

}
