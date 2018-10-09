import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

/**
 * Created by catalin on 08.12.2017.
 */
public class Main extends Application{
    public static void main(String[] args){
        new Joc();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       // Media sound = new Media(new File("tupac.mp3").toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(sound);
       //mediaPlayer.setAutoPlay(true);
    }
}
