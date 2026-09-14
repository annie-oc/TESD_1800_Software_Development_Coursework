// Author: Annie O'Connor
// Date: 9.14.26

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class CountdownTimer extends Application {

    // create all the instance variables

    // text field where the user enters the seconds
    private TextField textField;

    // label that displays the remaining seconds
    private Label timeLabel;

    // countdown every second
    private Timeline timer;

    // media player to play the music
    private MediaPlayer mediaPlayer;

    // store the number of seconds remaining
    private int seconds;

    @Override
    public void start(Stage primaryStage) {

        // create all the objects

        // create a pane to hold the graphical objects
        Pane pane = new Pane();

        // create a text field for the user to enter seconds
        textField = new TextField();

        // position the text field
        textField.setLayoutX(100);
        textField.setLayoutY(50);

        // set the width of the text field
        textField.setPrefWidth(200);

        // create a label to display the remaining seconds
        timeLabel = new Label("Enter seconds and press Enter");

        // position the label
        timeLabel.setLayoutX(100);
        timeLabel.setLayoutY(100);

        // add text field and label to pane
        pane.getChildren().addAll(textField, timeLabel);

        // listen for the user pressing enter in the text field
        textField.setOnAction(e -> startCountdown());

        // create a scene
        Scene scene = new Scene(pane, 400, 200);

        // set the scene on the stage
        primaryStage.setTitle("Countdown Timer");
        primaryStage.setScene(scene);

        // display the window
        primaryStage.show();
    }

    // this method starts the countdown
    private void startCountdown() {

        // get the number typed by the user
        seconds = Integer.parseInt(textField.getText());

        // display the starting number
        timeLabel.setText(String.valueOf(seconds));

        // create a key frame that happens every 1 second
        KeyFrame keyFrame = new KeyFrame(
            Duration.seconds(1),
            e -> {

                // subtract one second
                seconds--;

                // display the new number
                timeLabel.setText(String.valueOf(seconds));

                // check if the countdown has reached 0
                if (seconds <= 0 ) {

                    // (if it has) stop the countdown
                    timer.stop();

                    // and play the music
                    playMusic();
                }
            }
        );

        // create the timeline using the key frame
        timer = new Timeline(keyFrame);

        // make the timeline repeat continuously
        timer.setCycleCount(Timeline.INDEFINITE);

        // start the countdown
        timer.play();
    }

    // this method plays the music
    private void playMusic() {

        // create a media object using the music file
        Media media = new Media(
            new File("music.mp3").toURI().toString()
        );

        // create a media player using the media
        mediaPlayer = new MediaPlayer(media);

        // make the music repeat continuously
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        // start playing the music
        mediaPlayer.play();
    }

    // main method that launches the JavaFX program
    public static void main(String[] args) {
        launch(args);
    }
}
