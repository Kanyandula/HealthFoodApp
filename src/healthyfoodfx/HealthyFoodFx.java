/*
 * Class:           HealthyFoodFX
 * Description:     Main application class & entry point - a JavaFX application
 */
package healthyfoodfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ephraim Kanyandula
 */
public class HealthyFoodFx extends Application 
{
    // static instance of MainScreen class
    private static MainScreen mainScreen;

    //  singleton class - get a static reference so can be accessed from other classes
    public static MainScreen getMainScreen()
    {
        return mainScreen;
    }
    
    
    // JavaFX start() method - need to run the program
    @Override
    public void start(Stage primaryStage)
    {
        Group root = new Group();                       // Group - a container with no special layout to its child ndoes
        mainScreen = new MainScreen(root);              // create a MainScreen object
        
        // create the main Scene object
        Scene scene = new Scene(root, 800, 600);    
        mainScreen.startApp();
        
        // setup the JavaFX stage
        primaryStage.setTitle("Healthy Food Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    // class to manage application screen
    public class MainScreen
    {
        // Group - a container with no special layout to its child nodes        
        private final Group root;
        
        
      
        // screens
        private Splash splash;                  // splash layout
       private MainMenu menu;                  // menu layout
       private Content content;                // contennt
       private Login login;                    // login page
       private ContentVideo contentVideo;      // video content
        private ContentMenu contentMenu;        // message content 
       
        private ContentAudio contentAudio;       // audio message content
        private ContentWebView contentWebView;   //website content
        private Quiz quiz;                       //quiz questions page
        
        private Results results;                 //Results page    
        // MainScreen constructor
        private MainScreen(Group _root) 
                
        {
            this.root = _root;
        }
                
        // start teh app by opening the splash screen
        public void startApp()
        {
            splash = new Splash();
            root.getChildren().addAll(splash);
        }
               
        // change screens by changing the layout
        public void setScene(int screenNumber)
        {
            switch (screenNumber)
            {
                case 1:
                    // login
                    root.getChildren().remove(splash);
                    splash = null;
                    login = new Login();
                    root.getChildren().addAll(login);
                    break;
                    
                case 2:
                    // menu
                    root.getChildren().remove(login);
                    login = null;
                    root.getChildren().remove(content);
                    content = null;
                    root.getChildren().remove(contentMenu);
                    contentMenu = null;
                    root.getChildren().remove(contentVideo);
                    contentVideo = null;
                    root.getChildren().remove(contentWebView);
                   contentWebView = null;
                    
                    root.getChildren().remove(contentAudio);
                    contentAudio = null;
                    menu = new MainMenu();
                    root.getChildren().addAll(menu);
                    break;
                    
                    
                                 
                   
                    
                case 3:
//                    // content screen
                   root.getChildren().remove(menu);
                    menu = null;
                    root.getChildren().remove(contentMenu);
                    contentMenu = null;
                    root.getChildren().remove(contentWebView);
                    contentWebView = null;
                     root.getChildren().remove(contentVideo);
                    contentVideo = null;
                    root.getChildren().remove(contentAudio);
                    contentAudio = null;
                    content = new Content();
                    root.getChildren().addAll(content);
                    break;
                   
               case 4:
                    // content video
                    root.getChildren().remove(content);
                    content = null;
                    root.getChildren().remove(contentMenu);
                    contentMenu = null;
                    root.getChildren().remove(contentWebView);
                    contentWebView = null;
                    root.getChildren().remove(contentAudio);
                    contentAudio = null;
                   contentVideo = new ContentVideo();
                    root.getChildren().addAll(contentVideo);
                   break;
               
               case 5:
                   // content menu 
                    root.getChildren().remove(content);
                    content = null;
                   root.getChildren().remove(contentWebView);
                    contentWebView = null; 
                   root.getChildren().remove(contentVideo);
                    contentVideo = null;
                    root.getChildren().remove(contentAudio);
                    contentAudio = null;
                   contentMenu = new ContentMenu();
                   root.getChildren().addAll(contentMenu);
                   break;
                    
              case 6:
                   // content Web View
                   root.getChildren().remove(contentMenu);
                   contentMenu = null;
                   root.getChildren().remove(content);
                    content = null;
                    root.getChildren().remove(contentVideo);
                    contentVideo = null;
                    root.getChildren().remove(contentAudio);
                    contentAudio = null;
                   
                    contentWebView = new ContentWebView();
                    root.getChildren().addAll(contentWebView);
                    break;
                    
                  case 7:
                   // content Audio
                   root.getChildren().remove(contentMenu);
                   contentMenu = null;
                   root.getChildren().remove(content);
                    content = null;
                    root.getChildren().remove(contentWebView);
                   contentWebView = null;
                    root.getChildren().remove(contentVideo);
                    contentVideo = null;
                   
                    contentAudio = new ContentAudio();
                    root.getChildren().addAll(contentAudio);
                    break;   
                    
                    case 8:
                   // Quiz
                   root.getChildren().remove(contentMenu);
                   contentMenu = null;
                   root.getChildren().remove(content);
                    content = null;
                    root.getChildren().remove(contentWebView);
                   contentWebView = null;
                    root.getChildren().remove(contentVideo);
                    contentVideo = null;
                   
                    quiz = new Quiz();
                    root.getChildren().addAll(quiz);
                    break;    
                    
                     case 9:
                   // Results
                   root.getChildren().remove(contentMenu);
                   contentMenu = null;
                   root.getChildren().remove(content);
                    content = null;
                    root.getChildren().remove(contentWebView);
                    contentWebView = null;
                    root.getChildren().remove(contentVideo);
                    contentVideo = null;
                   
                    results = new Results();
                    root.getChildren().addAll(results);
                    break;    
                    
                   
                default:
                     break;
            }      
         }
    }    

    
    
    /**
     * Java main class - used to start the program
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}