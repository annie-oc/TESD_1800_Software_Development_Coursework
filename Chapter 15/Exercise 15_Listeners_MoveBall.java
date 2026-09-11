// Author: Annie O'Connor
// Date: 9.11.26

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MoveBall extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create the pane that contains the ball
        BallPane ballPane = new BallPane();

        // create the four arrow buttons
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");

        // create a horizontal box to hold the buttons
        HBox buttons = new HBox(10);

        // add the buttons to the HBox
        buttons.getChildren().addAll(
            btLeft, btRight, btUp, btDown
        );

        // center the buttons
        buttons.setAlignment(Pos.CENTER);

        // bind the click action of the left button
        btLeft.setOnAction(e -> ballPane.left());

        // bind the click action of the right button
        btRight.setOnAction(e -> ballPane.right());

        // bind the click action of the up botton
        btUp.setOnAction(e -> ballPane.up());

        // bind the click action of the down button
        btDown.setOnAction(e -> ballPane.down());

        // create a border pane for the entire program
        BorderPane borderPane = new BorderPane();

        // put the ball pane in the center
        borderPane.setCenter(ballPane);

        // put the buttons at the bottom
        borderPane.setBottom(buttons);

        // create the scene
        Scene scene = new Scene(borderPane, 400, 350);

        // set the title of the window
        primaryStage.setTitle("Bounce the Ball");

        // put the scene on the stage
        primaryStage.setScene(scene);

        // display the window
        primaryStage.show();
    }

    // main method
    public static void main(String[] args) {
        launch(args);
    }
}
