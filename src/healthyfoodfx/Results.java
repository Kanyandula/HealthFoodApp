/*
 * Class:           Results
 * Description:     Quiz reaults screen 
 */
package healthyfoodfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Ephraim kanyandula
 */
public class Results extends Parent 
{
     // layout
    private final VBox vboxMenu = new VBox();
    
    // Text textMessage;
    // UI nodes
    Label label = new Label("RIGHT ANSWERS");
    Label ans1 = new Label("1.Cassava");
    Label ans2 = new Label("2.Apples");
    Label ans3 = new Label("3.Salmon");
    Label ans4 = new Label("4.Guava");
    Label ans5 = new Label("5.Coffee Creamer");
    
    
    



    // constructor
    Results()
    {
        createNodesForUI();
        //addNodesToLayout();
    }
    
    
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
        
        
        
    label.setFont(new Font("Cambria", 26));
    label.setTranslateY(230);
    label.setTranslateX(230);
    
//    buttons.setTranslateY(400);
//    buttons.setTranslateX(280);

        ans1.setTranslateY(320);
        ans1.setTranslateX(280);
        
         ans2.setTranslateY(340);
        ans2.setTranslateX(280);
        
         ans3.setTranslateY(360);
        ans3.setTranslateX(280);
        
         ans4.setTranslateY(380);
        ans4.setTranslateX(280);
        
         ans5.setTranslateY(400);
        ans5.setTranslateX(280);
        
       
        
    
    
     
        

    HBox answerArea = new HBox();
    answerArea.setTranslateY(330);
    answerArea.setTranslateX(260);
    answerArea.setSpacing(20);


    
    
    


    
    
    
    



    
    
    


    Stage stage = new Stage();
    Pane pane = new Pane();
    pane.setStyle("-fx-background-color: #FFFFFF;");
    Scene scene = new Scene(pane, 800, 500);
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();

    pane.getChildren().addAll(label,ans1,ans2,ans3,ans4,ans5);

        
    }
    
    
   
 


    
}
