/*
 * Class:           ContentAudio
 * Description:     Content audio screen 
 */
package healthyfoodfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Ephraim kanyandula
 */
public class ContentAudio extends Parent {
     // layout
    private BorderPane borderPane;
    
    // UI nodes
    
    //private Label topLbl;
    private Button btnMenu;
    private Button btnAudio;
   private boolean stop = true;
   private Label  bottomLbl;
   private ChoiceBox lessonchoiceBox;
   private   Text lessonsLabel;

     // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private VBox leftVb;
    private  VBox rightVb;
    private VBox bottomVb;
    
        
    // constructor
    public ContentAudio() 
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
        
       
        
         
        
        // Setup UI elements here
        //topLbl = new Label("Motorbike Elearning");
        btnMenu = new Button("Main Menu");
       
        bottomLbl = new Label("Designed by Ephraim Kanyandula");

        // new VBox s to hold UI elements
        topVb = new VBox();
        leftVb = new VBox();
        rightVb = new VBox();
        bottomVb = new VBox();
        
         // button event handler
         
        
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
      
      btnAudio = new Button();
        btnAudio.setText("Play/Stop Audio");
        btnAudio.setOnAction(new EventHandler<ActionEvent>() {
          
            @Override
            public void handle(ActionEvent event) {
                //calling the AudioClip's play method
                AudioClip audioClip = new AudioClip(this.getClass().getResource("Food.mp3").toString());
                
                if (stop == true ){
                    
                audioClip.play();
                stop = false;
                }
                else {
                audioClip.stop();
                stop= true;
                }
            }
        });
        
      
     
    }
    
   
    
    
    // configure the UI (styling and position)
    private void configureUINodes()
    {
        // Set fonts for all labels using CSS
       // topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    
       //bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       
       // Configure the VBoxes
       //topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        leftVb.getChildren().add (lessonsLabel);
       leftVb.getChildren().add (lessonchoiceBox);
      
       leftVb.setAlignment(Pos.CENTER);      
       
       rightVb.getChildren().add(btnMenu);
       rightVb.setAlignment(Pos.CENTER);       
   
      // bottomVb.getChildren().add(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;"); 
       
    }
    
    
    public void changeScreen(int screenNumber)
        {
            
            
        }
        
    
     // add the child nodes to the layout
    private void addNodesToLayout()
    {
       // Add VBoxes to Pane
       borderPane.setTop(topVb);
       borderPane.setLeft(leftVb);
       borderPane.setRight(rightVb);
       borderPane.setBottom(bottomVb);
       borderPane.setCenter(btnAudio);
 
        getChildren().add(borderPane);
    }
    
    
    
}
