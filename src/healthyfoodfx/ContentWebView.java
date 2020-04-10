/*
 * Class:           WebView
 * Description:      WebView screen 
 */
package healthyfoodfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Ephraim kanyandula
 */
public class ContentWebView extends Parent
{
      
   // layout
    private BorderPane borderPane;
    
    // UI nodes
    
    private Button btnMenu;
    private WebView view;
   
    
   private ChoiceBox lessonchoiceBox;
   private   Text lessonsLabel;

     // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private VBox leftVb;
    private  VBox rightVb;
    private VBox bottomVb;
     
    
        
    // constructor
    public ContentWebView() 
    {
        createNodesForUI();
        configureUINodes();       
        addNodesToLayout();
    }


    
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
        // layout object
        borderPane = new BorderPane(); 
        borderPane.setPrefSize(800,600);
        
        // Generating a webpage for heathyfood
        view = new WebView();
         view.setMinSize(500, 400);
         view.setPrefSize(500, 400);
         final WebEngine eng = view.getEngine();
         eng.load("https://www.healthyfood.co.nz/");
       
        
       
        
        // Setup UI elements here
       
        btnMenu = new Button("Main Menu");
       
        

        // new VBox s to hold UI elements
        topVb = new VBox();
        leftVb = new VBox();
        rightVb = new VBox();
        bottomVb = new VBox();
       
        
         // button event handler to go to main memu
         
        
        btnMenu.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                HealthyFoodFx.getMainScreen().setScene(2);
                
                
                
            }
        });
        
        
         //Label for Lessons
          lessonsLabel = new Text("Lessons"); 
          lessonsLabel.setFont(new Font("Cambria", 15)); //Lessons label font
        
         //Choice box for location 
      lessonchoiceBox = new ChoiceBox(); 
      lessonchoiceBox.getItems().addAll
         ("Content", "Content Video", "Content Message", "Content WebView", "Content Audio"); 
      //set a defalt value
      lessonchoiceBox.setValue("Content");
        
      lessonchoiceBox.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                
                
                
                if(lessonchoiceBox.getValue().equals("Content") ){
                    
                HealthyFoodFx.getMainScreen().setScene(3);
                
                
                }
                
               if(lessonchoiceBox.getValue().equals("Content Video") ){
                    
                HealthyFoodFx.getMainScreen().setScene(4);
                
                
                }
                
                if(lessonchoiceBox.getValue().equals("Content Message") ){
                    
                HealthyFoodFx.getMainScreen().setScene(5);
                
                
                }
                 if(lessonchoiceBox.getValue().equals("Content WebView") ){
           
                HealthyFoodFx.getMainScreen().setScene(6);
                
                
                }
               
                if(lessonchoiceBox.getValue().equals("Content Audio") ){
           
                HealthyFoodFx.getMainScreen().setScene(7);
                
                
                }
                
                
            }
        });
      
     
    }
    
   
    
    
    // configure the UI (styling and position)
    private void configureUINodes()
    {
        
       
       // Configure the VBoxes
       
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        leftVb.getChildren().add (lessonsLabel);
       leftVb.getChildren().add (lessonchoiceBox);
      
       leftVb.setAlignment(Pos.CENTER);      
       
       rightVb.getChildren().add(btnMenu);
       rightVb.setAlignment(Pos.CENTER);  
       
      
     
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
       
      
       
       
    }
    
   
         
    
        
    
     // add the child nodes to the layout
    private void addNodesToLayout()
    {
       // Add VBoxes to Pane
       borderPane.setTop(topVb);
       borderPane.setLeft(leftVb);
       borderPane.setRight(rightVb);
       borderPane.setBottom(bottomVb);
       borderPane.setCenter(view);
 
        getChildren().add(borderPane);
    }
    
    
    
}

    


