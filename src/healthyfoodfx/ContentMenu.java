/*
 * Class:           ContentMenu
 * Description:     Example of a menu
 */
package healthyfoodfx;

/**
 *
 * @author Peter
 */
import javafx.application.Application;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;

/**
 *
 * @author Ephraim kanyandula
 */
public class ContentMenu extends Parent
{
    // layout
    private BorderPane borderPane;
    
    // JavaFX menu
    Menu appMenu;
    MenuBar menuBar;
    
    // UI nodes
    private Label midLbl;
    private Label topLbl;
    private Button btnMenu;
    
    private Label bottomLbl;
     private ChoiceBox lessonchoiceBox;
   private   Text lessonsLabel;
    
    Text messageText;

     // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private VBox leftVb;
    private  VBox rightVb;
    private VBox bottomVb;
    
        
    // constructor
    public ContentMenu() 
    {
        createNodesForUI();
        configureUINodes();       
        addNodesToLayout();
    }


    
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
        //menu
        appMenu = new Menu("Elearning");
        
        // menu items
        MenuItem pauseLesson = new MenuItem("Pause Lesson");
        appMenu.getItems().add(new MenuItem("Start Lesson"));
        appMenu.getItems().add(new MenuItem("Save Progress"));
        appMenu.getItems().add(pauseLesson);
        
        // menu bar
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(appMenu);
        
        // layout object
        borderPane = new BorderPane(); 
        borderPane.setPrefSize(800,600);
        
   
        // Setup UI elements here
        topLbl = new Label("Motorbike Elearning");
        
        // bike text
        messageText = new Text();
        messageText.setFont(new Font(14));
        messageText.setWrappingWidth(500);
        messageText.setTextAlignment(TextAlignment.JUSTIFY);
       messageText.setText("\"The Foods Standards Agency defines a balanced diet as "
                + " having ‘a variety of foods  basing meals on starchy foods and eating –"
                + " at least 5 portions of fruit and veg a day.’ They also recommend  "
                + "having moderate amounts of fish (2 portions a week one being oily) " +
        " moderating the amount of protein you have and having small or occasional."
                + " amounts of food high in fat or sugar. ");;
        
        btnMenu = new Button("Main Menuu");
        
        bottomLbl = new Label("Designed by Ephraim Kanyandula");

        // new VBox s to hold UI elements
        topVb = new VBox();
        leftVb = new VBox();
        rightVb = new VBox();
        bottomVb = new VBox();
        
        // button event handler
        pauseLesson.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Pausing lesson now......");
            }
        });
        
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
        topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    
       bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       
       // Configure the VBoxes
       topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");
        leftVb.getChildren().add (lessonsLabel);
       leftVb.getChildren().add (lessonchoiceBox);
       
       //leftVb.getChildren().add(btnBack);
       leftVb.setAlignment(Pos.CENTER);      
       
       rightVb.getChildren().add(btnMenu);
       rightVb.setAlignment(Pos.CENTER);       
   
       bottomVb.getChildren().add(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;");  
    }
    
        
    
     // add the child nodes to the layout
    private void addNodesToLayout()
    {
       // Add VBoxes to Pane
       borderPane.setTop(menuBar);
       
       borderPane.setLeft(leftVb);
       borderPane.setRight(rightVb);
       borderPane.setBottom(bottomVb);
       borderPane.setCenter(messageText);
        
        getChildren().add(borderPane);
    }
    
    
    
}
