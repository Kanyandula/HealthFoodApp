/*
 * Class:           Login
 * Description:     Example UI for a login screen
 */
package healthyfoodfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Ephraim
 */
public class Login extends Parent
{
    // layout for this screen - GridPane
     private GridPane grid;
     
     // UI nodes
     private Label nameLabel;
     private TextField nameInput;
     private Label passLabel;
     private TextField passInput;
     private Button loginButton;
     
     
     
    // Login constructor
    public Login() 
    {
        createNodesForUI();
        
        addNodesToLayout();     
    }
    
    
     // create the nodes objects for the UI
    private void createNodesForUI()
    {
        //GridPane with 10px padding around edge
        grid = new GridPane();
        grid.setPrefSize(800,600);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //Name Label - constrains use (child, column, row)
        nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        nameInput = new TextField("Ephraim");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password Label
        passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password Input
        passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        //Login
        loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        
         // button event handler
        loginButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                HealthyFoodFx.getMainScreen().setScene(2);
            }
        });
        
    }
    
    
     // add the child nodes to the layout
    private void addNodesToLayout()
    {
          //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        
        getChildren().add(grid);
    }
    
    
    
}
