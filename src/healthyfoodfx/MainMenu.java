/*
 * Class:           Menu
 * Description:     Menu layout extends the JavaFX Parent - main application menu
 */
package healthyfoodfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

/**
 * @author ephraim Kanyandula
 */
public class MainMenu extends Parent
{
    // layout
    private VBox vboxMenu = new VBox();
    
    // UI nodes
    private Label nameLabel;
    private Button btnStart;
    private Button btnHelp;
    private Button btnSettings;
    private Button btnQuit;
    private Button btnQuiz;
  
    
    // constructor
    MainMenu()
    {
        createNodesForUI();
        addNodesToLayout();
    }
    
    
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
        // Vbox layout
        vboxMenu = new VBox();
        
        nameLabel = new Label("Main Menu:");
        
        // ui buttons
        btnStart = new Button("Start");
        btnHelp = new Button("Help");
        btnSettings = new Button("Settings");
        btnQuit = new Button("Quit");
        btnQuiz = new Button("Quiz");
        
        
        btnStart.setPrefWidth(150);
        btnHelp.setPrefWidth(150);
        btnSettings.setPrefWidth(150);
        btnQuit.setPrefWidth(150);
        btnQuiz.setPrefWidth(150);
       
        
        // set Vbox layout details and size
        vboxMenu.setPrefSize(800,600);
        vboxMenu.setSpacing(10);
        vboxMenu.setPadding(new Insets(0, 20, 10, 20)); 
        vboxMenu.setAlignment(Pos.CENTER);       
        
       // button event handler
        btnStart.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                HealthyFoodFx.getMainScreen().setScene(3);
            }
        });
        
        // button menu event handler
        btnQuiz.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                HealthyFoodFx.getMainScreen().setScene(8);
            }
        });
        //Quite button
        btnQuit.setOnAction(e -> Platform.exit());
        
        
        
        
    }
    
    
    // add the child nodes to the layout
    private void addNodesToLayout()
    {
          //Add everything to layout
        vboxMenu.getChildren().addAll( nameLabel, btnStart, btnHelp, btnSettings,btnQuiz,btnQuit);
        
        getChildren().add(vboxMenu);
    }
    
    
    
}
