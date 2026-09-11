// Author: Annie O'Connor
// Date: 9.11.26

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MoveMessage extends Application {

    // create text object
    // displays text on the screen
    private Text message = new Text("Programming is fun!");

    // keep track of how far the message moves
    private double x = 150;

    @Override
    public void start(Stage primaryStage) {

        // create the pane where the message will appear
        Pane messagePane = new Pane();

        // set the starting position of the message
        message.setX(x);
        message.setY(100);

        // set the starting color of the message
        message.setFill(Color.BLACK);

        // add the message to the pane
        messagePane.getChildren().add(message);

        // create the buttons

        // create a button that moves the message left
        Button btLeft = new Button("Left");

        // button that moves the message right
        Button btRight = new Button("Right");

        // include event handling for the buttons

        // run this code when the left button is clicked
        btLeft.setOnAction(e -> {

            // move the message 10 pixels left
            x -= 10;

            // don't let it go past the left side
            if (x < 0) {
                x = 0;
            }

            // update the message's position
            message.setX(x);
        });

        // run this code when the right button is clicked
        btRight.setOnAction(e -> {

        // move the message 10 pixels right
        x += 10;

        // find how wide the pane is
        double paneWidth = messagePane.getWidth();

        // find out how wide the message is
        double messageWidth = message.getLayoutBounds().getWidth();

        // don't let it go past the right side
        if (x + messageWidth > paneWidth) {
            x = paneWidth - messageWidth;
        }

        // update the message's position
        message.setX(x);
    });

    // create the radio buttons

    // red
    RadioButton rbRed = new RadioButton("Red");

    // green
    RadioButton rbGreen = new RadioButton("Green");

    // blue
    RadioButton rbBlue = new RadioButton("Blue");

    // put them in a toggle group
    // so only one button can be selected at atime

    ToggleGroup = colorGroup = new ToggleGroup();

    rbRed.setToggleGroup(colorGroup);
    rbGreen.setToggleGroup(colorGroup);
    rbBlue.setToggleGroup(colorGroup);

    // make the red one selected when the program starts
    rbRed.setSelected(true);

    // when red is selected, change message to red
    rbRed.setOnAction(e -> {
        message.setFill(Color.RED);
    });

    // when green is selected, turn message green
    rbGreen.setOnAction(e -> {
        message.setFill(Color.GREEN);
    });

    // when blue is selected, turn message blue
    rbBlue.setOnAction(e -> {
        message.setFill(Color.BLUE)
    });

    // put the buttons in an HBox
    // HBox puts items horizontally

    // create HBox for right and left buttons
    HBox buttonBox = new HBox(10);

    // add right and left buttons to HBox
    buttonBox.getChildren().addAll(btLeft, btRight);

    // put radio buttons in another HBox

    // create new HBox for color choices
    HBox colorBox = new HBox(10);

    // add the radio buttons to the HBox
    colorBox.getChildren().addAll(rbRed, rbGreen, rbBlue);

    // create the main layout

    // create border pane so we can put stuff in different places
    BorderPane pane = new BorderPane();

    // put the message pane in the center
    pane.setCenter(messagePane);

    // put left and right buttons at bottom
    pane.setBottom(buttonBox);

    // put color buttons at the top
    pane.setTop(colorBox);

    // create the scene and stage

    // create 400pixels x 200pixels scene
    Scene scene = new Scene(pane, 400, 200);

    // title the window
    primaryStage.setTitle("Move Message");

    // put scene inside window
    primaryStage.setScene(scene);

    // display the window
    primaryStage.show();
}

// the main method starts the JavaFX program
public static void main(String[] args) {
    launch(args);
}
}
