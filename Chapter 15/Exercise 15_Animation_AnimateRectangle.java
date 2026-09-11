// Author: Annie O'Connor
// Date: 9.11.26

// tell the animation what to do at a certain point in time
import javafx.animation.KeyFrame;

// control the animation
import javafx.animation.Timline;

// make this a JavaFX program
import javafx. application.Application;

// everything inside the window
import javafx.scene.Scene;

// which mouse button did the user click?
import javafx.scene.input.MouseButton;

// create the drawing area
import javafx.scene.layout.Pane;

// let's me give the shapes color
import javafx.scene.paint.Color;

// let's me create the pentagon
import javafx.scen.shape.Polygon;

// let's me create the rectangle
import javafx.scene.shape.Rectangle;

// creates the application window
import javafx.stage.Stage;

// how much time will this take?
import javafx.util.Duration;

public class AnimateRectangle extends Application {

    // create a rectangle that moves around the pentagon
    private Rectangle rectangle = new Rectangle(20, 20);

    // create the timeline for the animation
    private int side = 0;

    /* keep track of how far the rectangle has treveled
     * along the current side */
    private double progress = 0;

    // how quickly the rectangle moves
    private double speed = 0.01;

    @Override
    public void start(Stage primaryStage) {

        // create a pan that holds the rectangle and the pentagon
        Pane pane = new Pane();

        // create the pentagon
        Polygon pentagon = new Polygon();

        // add the five points of the pentagon
        pentagon.getPoints().addAll(
            200.0, 50.0, // point 1 - top
            350.0, 150.0, // point 2 - upper right
            290.0, 300.0, // point 3 - lower right
            110.0, 300.0, // point 4 - lower left
            50.0, 150.0 // point 5 - upper left
        );

        // give the pentagon a fill color
        pentagon.setFill(Color.LIGHTGRAY);

        // give the pentagon a black outline
        pentagon.setStroke(Color.BLACK);

        // set the rectangle's color
        rectangle.setFill(Color.BLUE);

        // start the rectangle at the first point
        rectangle.setX(190);
        rectangle.setY(40);

        // add the pentagon and rectangle to the pane
        pane.getChildren().addAll(pentagon, rectangle);

        // create the animation
        animation = new Timeline(
            new KeyFrame(Duration.millis(20), e -> moveRectangle())
        );

        // make the animation repeat forever
        animation.setCycleCount(Timeline.INDEFINITE);

        // start the animation
        animation.play();

        // detect mouse clicks
        pane.setOnMouseClicked(e -> {

            // if the left button is clicked = pause the animation
            if (e.getButton() == MouseButton.PRIMARY) {
                animation.pause();
            }

            // if the right button is clicked = resume animation
            if (e.getButton() == MouseButton.SECONDARY) {
                animation.play();
            }
        });

        // create the scene
        Scene scene = new Scene(pane, 400, 350);

        // set the title of the window
        primaryStage.setTitle("Rectangle Around Pentagon");

        // put the scene on the stage
        primaryStage.setScene(scene);

        // display the window
        primaryStage.show();
    }

    // the method that moves the rectangle around the pentagon
    public void moveRectangle() {

        // five points of the pentagon
        double[] xPoints = {
            200, 350, 290, 110, 50
        };

        double[] yPoints = {
            50, 150, 300, 300, 150
        };

        // find the current point
        int currentPoint = side;

        // find the next point
        int nextPoint = (side + 1) % 5;

        // get the x and y coordinates of the current point
        double startX = xPoints[currentPoint];
        double startY = yPoints[currentPoint];

        // get the x and y coordinates of the next point
        double endX = xPoints[nextPoint];
        couble endY = yPoints[nextPoint];

        // calculate the rectangle's new position
        double newX = startX + (endX - startX) * progress;
        double newY = startY + (endY - startY) * progress;

        // move the rectangle
        rectangle.setX(newX - 10);
        rectangle.setY(newY - 10);

        // change the rectangle's opacity as it moves
        rectangle.setOpacity(0.2 + 0.8 * progress);

        // move a little farther along the current side
        progress += speed;

        // check if the rectangle has reached the next point
        if (progress >= 1) {

            // then move to the next side
            side++;

            // if we've gone around all 5 sides...
            if (side == 5) {
                side = 0;
            }

            // ...then start from the beginning
            progress = 0;
        }
    }

    // main method
    public static void main(String[] args) {
        launch(args);
    }
}
