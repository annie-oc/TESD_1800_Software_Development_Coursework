// Author: Annie O'Connor
// Date: 9.10.26

// I want to use all of these classes from JavaFX

// starts the program
import javafx.application.Application;

// store's the polygon's points
import javafx.collections.ObservableList;

// contains the stop sign pane
import javafx.scene.Scene;

// makes the sign red and the text white
import javafx.scene.paint.Color;

// gives me the window containing the stop sign
import javafx.stage.Stage;

// creates the eight sides
import javafx.scene.shape.Polygon;

// displays "STOP"
import javafx.scene.text.Text;

// makes "STOP" larger
import javafx.scene.text.Font;

// rotates the octagon
import javafx.scene.transform.Rotate;

// create a class called StopSign that's a JavaFX application
public class StopSign extends Application {
    @Override
    public void start(Stage primaryStage) {
        // make the sign 400 pixels wide and 400 pixels tall
        Scene scene = new Scene(new StopSign(), 400, 400);
        // set the title at the top of the window
        primaryStage.setTitle("Stop Sign");
        primaryStage.setScene(scene);
        // display the window on the screen
        primaryStage.show();
    }

    // start the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
    
    class StopSignPane extends Pane {
        // draw the stop sign
        private void paint() {
            // create a polygon
            Polygon polygon = new Polygon();
            // make it red
            polygon.setFill(Color.RED);
            polygon.setStroke(Color.RED);
            // get the list of points for the polygon
            ObservableList<Double> list = polygon.getPoints();

            // find the center of the pane
            double centerX = getWidth() / 2, centerY = getHeight() / 2;
            
            // determine hoe big the stop sign will be
            double radius = Math.min(getWidth(), getHeight()) * 0.4;

            // we want 8 sides
            int s = 8;

            // calculate the location of each corner of the octagon
            for (int i = 0; i < s; i++) {
                // place the points evenly around a circle
                list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
                list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
            }

            // rotate the octagon 22.5 degrees
            // so it looks like an actual stop sign
            polygon.setRotate(22.5);

            // get ride of anything currently inside the pane
            getChildren().clear();

            // put the new polygon inside the pane
            getChildren().add(polygon);

            // create the STOP text
            Text text = new Text("STOP");

            // make the text white
            text.setFill(Color.WHITE);

            // make the text larger
            text.setFont(Font.font(40));

            // center the text horizontally
            text.setX(centerX - text.getLayoutBounds().getWidth() / 2);

            // center the text vertically
            text.setY(centerY + text.getLayoutBounds().getHeight() / 4);

            // add the text to the pane
            getChildren().add(text);
        }

        // redraw the sign whenever the pane's width changes
        @Override
        public void setWidth(double width) {
            super.setWidth(width);
            paint();
        }

        // redraw the sign whenever the pane's height changes
        @Override
        public void setHeight(double height) {
            super.setHeight(height);
            paint();
        }
    }
