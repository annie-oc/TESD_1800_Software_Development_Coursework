// Author: Annie O'Connor
// Date: 9.11.26

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {

    // create the circle that represents the ball
    private Circle circle;

    // how far the ball moves each time a button is clicked
    private double radius = 20;

    // constructor
    public BallPane() {

        // create the circle
        circle = new Circle(radius);

        // set the color
        circle.setFill(Color.BLUE);

        // put the circle in the middle of the pane
        circle.setCenterX(200);
        circle.setCenterY(150);

        // add the circle to the pane
        getChildren().add(circle);
    }

    // move the ball left
    public void left() {

        // make sure the ball doesn't go off screen
        if (circle.getCenterX() - radius > 0) {

            // move the ball 10 pixels to the left
            circle.setCenterX(circle.getCenterX() - 10);
        }
    }

    // move the ball right
    public void right() {

        // make sure the ball doesn't go off screen
        if (circle.getCenterX() + radius < getWidth()) {

            // move the ball 10 pixels to the right
            circle.setCenterX(circle.getCenterX() + 10);
        }
    }

        // move the ball up
        public void up() {

            // make sure the ball doesn't go off screen
            if (circle.getCenterY() - radius > 0) {

                // move the ball 10 pixels up
                circle.setCenterY(circle.getCenterY() - 10);
            }
        }

        // move the ball down
        public void down() {

            // make sure the ball doesn't go off screen
            if (circle.getCenterY() + radius < getHeight()) {

                // move the ball 10 pixels down
                circle.setCenterY(circle.getCenterY() + 10);
            }
        }
    }
