/*
 * Class:           Splash
 * Description:     Splash layout extends the JavaFX Parent class ( base class for all nodes that have children in the scene graph)
 */
package healthyfoodfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

/**
 *
 * @author Peter
 */
public class Splash extends Parent
{
    // layout for this screen
    private StackPane stackPane;
    private ImageView background;
    // UI nodes
    Button btnWelcome = new Button();
    
    
    
    // Splash constructor
    public Splash()
    {
        stackPane = new StackPane();
        
        createNodesForUI();      
        addNodesToLayout();      
    }
    
    
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
        btnWelcome = new Button();
        btnWelcome.setText("Welcome to the Healthy Food App");
        btnWelcome.setFont(new Font("Cambria", 15));
        
        // button event handler
        btnWelcome.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                HealthyFoodFx.getMainScreen().setScene(1);
            }
        });
         
        // add background image to image object
        background = new ImageView(new Image(getClass().getResourceAsStream("welcome.png")));
    }
    
    
    // add the child nodes to the layout
    private void addNodesToLayout()
    {
        // add to this object's layout
        stackPane.getChildren().addAll(background,btnWelcome);
        
        // then add to the application's layout
        getChildren().add(stackPane);
    }
    
    
    
}
