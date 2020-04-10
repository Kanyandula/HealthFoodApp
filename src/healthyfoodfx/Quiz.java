/*
 * Class:           Quiz
 * Description:     This is the class that containbs all the code for the Quiz
 */
package healthyfoodfx;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Ephraim kanyandula
 */
public class Quiz  extends Parent
{
    
    // layout
    private VBox vboxMenu = new VBox();
    
    
    // UI nodes
    private int questionNumber = 0 ;
    //counter for next button
    private int counter =0 ;

private int max = 5;
String[] question = new String[max];

String [] answer1 = new String[max];

String [] answer2 = new String [max];

String [] answer3 = new String[max];

Label label = new Label();

Label userAnswer = new Label();

RadioButton choice1 = new RadioButton();

RadioButton choice2 = new RadioButton();

RadioButton choice3 = new RadioButton();

ToggleGroup answers = new ToggleGroup();

Button next = new Button("Next");
Button results = new Button ("Results");

RadioButton userAnswered;

TilePane buttons = new TilePane();

Button answer = new Button("Answer");
    
    // constructor
    Quiz()
    {
        createNodesForUI();
        //addNodesToLayout();
    }
    
    
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
         question[0]= "Which one of these is not a fruit";
    question[1] = "Which of the following foods are sources of fibre?";
    question[2] = " Which of the following count as “oily” fish?";
    question[3] = "which fruit has the most vitamin c?";
    question[4] = "Which one is unhealthy food?";


    label.setFont(new Font("Cambria", 26));
    label.setTranslateY(230);
    label.setTranslateX(230);
    label.setText(question[0]);

    HBox answerArea = new HBox();
    answerArea.setTranslateY(330);
    answerArea.setTranslateX(260);
    answerArea.setSpacing(20);


    answer1 [0] =  "Mango";
    answer2[0] = "Cassava";
    answer3 [0]= "Orange";
    
    answer1 [1] =  "Sour cream"; 
    answer2[1] = " Apples";
    answer3 [1]= "Steak";
    
    answer1 [2] =  "Haddock.";
    answer2[2] = " Salmon";
    answer3 [2]= " Cod.";   
    
    
    answer1 [3] =  "Kiwi";
    answer2[3] = "Guava";
    answer3 [3]= "Orange";
    
    answer1 [4] = "Rice";
    answer2 [4] = "Coffee Creamer";  
    answer3 [4]= "Noodles";



    choice1.setText(answer1[0]);
    choice2.setText(answer2[0]);
    choice3.setText(answer3[0]);

    choice1.setToggleGroup(answers);
    choice2.setToggleGroup(answers);
    choice3.setToggleGroup(answers);

    answer.setMaxWidth(Double.MAX_VALUE);
    answer.setOnAction(e -> questionAnswered());

    answers.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

           userAnswered = (RadioButton) newValue.getToggleGroup().getSelectedToggle(); // Cast object  to radiobutton

        }
    });
   userAnswer.setTranslateY(280);
   userAnswer.setTranslateX(360);
   userAnswer.setFont(new Font("Cambria", 16));

    answerArea.getChildren().addAll(choice1, choice2, choice3);
    
    
    results.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
                HealthyFoodFx.getMainScreen().setScene(9);
            }
        });



    //next.setOnAction(e -> nextQuestion());
    next.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event)
            {
               nextQuestion();
               counter++;
               if (counter == 4) {
                     next.setDisable(true);
                  }
            }
        });
    
    next.setMaxWidth(Double.MAX_VALUE);


    buttons.setTranslateY(400);
    buttons.setTranslateX(280);
    buttons.setHgap(5);

    buttons.getChildren().addAll(next);
    
    

    answer.setTranslateX(550);
    answer.setTranslateY(330);
    
    results.setTranslateX(550);
    results.setTranslateY(360);


    Stage stage = new Stage();
    Pane pane = new Pane();
    pane.setStyle("-fx-background-color: #FFFFFF;");
    Scene scene = new Scene(pane, 800, 500);
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();

    pane.getChildren().addAll(label, answerArea, buttons, answer, userAnswer, results);

        
    }
    
    
   
    
    public void questionAnswered(){

    if (userAnswered.equals(choice2)) {
        userAnswer.setText("Correct");
    } else {
        userAnswer.setText("Wrong answer");
    }

}

public void nextQuestion() {
    questionNumber = (questionNumber + 1) % question.length ;
    label.setText(question[questionNumber]);
    choice1.setText(answer1[questionNumber]);
    choice2.setText(answer2[questionNumber]);
    choice3.setText(answer3[questionNumber]);


    userAnswer.setText(" ");

    }
    
}
