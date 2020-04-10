/*
 * Class:           Content Vide
 * Description:     Content video screen 
 */
package healthyfoodfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.net.URL;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author Peter
 */
public class ContentVideo extends Parent
{
     // layout
    private BorderPane borderPane;
    
    // UI nodes
    //private Label topLbl;
    private Button btnMenu;
    private Button stopVideo;
    //private Label bottomLbl;
    
     private ChoiceBox lessonchoiceBox;
   private   Text lessonsLabel;

     // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private  VBox leftVb;
    private  VBox rightVb;
    private  VBox bottomVb;
     
     // JavaFX media (video) objects
     private Media media;
     private MediaView mediaView;
     private MediaPlayer player;
    
     
     // constructor
    public ContentVideo() 
    {
        createNodesForUI();
        createVideoPlayer();
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
        
        btnMenu= new Button("Main Menu");
        stopVideo= new Button ("Stop Video");
        //bottomLbl = new Label("Designed by Student XYZ");

        // new VBox s to hold UI elements
        topVb = new VBox();
        leftVb = new VBox();
        rightVb = new VBox();
        bottomVb = new VBox();
        
         // button event handler
       stopVideo.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                
                 player.stop();
            }
        });
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
        // Set fonts for all labels using CSS
        //topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    
       //bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       
       // Configure the VBoxes
       //topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
       leftVb.getChildren().add (lessonsLabel);
       leftVb.getChildren().add (lessonchoiceBox);
        
       
       
       
           
       
       
       //leftVb.getChildren().add(btnBack);
       leftVb.setAlignment(Pos.CENTER);
       
      
       
       
       rightVb.getChildren().add(stopVideo);
       rightVb.getChildren().add(btnMenu);
       
       rightVb.setAlignment(Pos.CENTER);       
   
       //bottomVb.getChildren().add(bottomLbl);
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
       
       borderPane.setCenter(mediaView);
        
       getChildren().add(borderPane);
    }
    
    
    
   // create media and player objects and configure
    private void createVideoPlayer()
    {
         // Locate the media content (video) in the CLASSPATH
        URL mediaUrl = getClass().getResource("healthyVideo.mp4");
        String mediaStringUrl = mediaUrl.toExternalForm();
        
        media = new Media(mediaStringUrl);

        // Create a Media Player
         player = new MediaPlayer(media);

        // Automatically begin the playback
        player.setAutoPlay(true);

        // Create a 400X300 MediaView
        mediaView = new MediaView(player);
        mediaView.setFitWidth(400);
        mediaView.setFitHeight(300);   
        mediaView.setSmooth(true);
    }


    
}