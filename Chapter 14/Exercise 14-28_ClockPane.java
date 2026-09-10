// Author: Annie O'Connor
// Date: 9.10.26

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
    // create variable to store the current time
    private int hour;
    private int minute;
    private int second;

    // make the hour and minute hands visible
    // make the second hand invisible
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = false;

    // use the no-argument constructor
    // b/c we're not giving the clock a specific time
    // this constructor gets the current time from the computer
    public ClockPane() {
        setCurrentTime();
    }

    // create a clock with a specific hour, minute and second
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // gives me the current hour
    public int getHour() {
        return hour;
    }

    // change the hour
    public void setHour(int hour) {
        this.hour = hour;
        // redraw the clock
        paintClock();
    }

    // gives me the current minute
    public int getMinute() {
        return minute;
    }

    // change the minute
    public void setMinute(int minute) {
        this.minute = minute;
        // redraw the clock
        paintClock();
    }

    // gives me the current second
    public int getSecond() {
        return second;
    }

    // change the second
    public void setSecond(int second) {
        this.second = second;
        // redraw the clock
        paintClock();
    }

    // get the current time from the computer
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        // get the current hour
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        // get the current minute
        this.minute = calendar.get(Calendar.MINUTE);
        // get the current second
        this.second = calendar.get(Calendar.SECOND);

        // redraw the clock using the new time
        paintClock();
    }

    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public void setHourHandVisible(boolean visible) {
        this.hourHandVisible = visible;
        paintClock();
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public void setMinuteHandVisible(boolean visible) {
        this.minuteHandVisible = visible;
        paintClock();
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    public void setSecondHandVisible(boolean visible) {
        this.secondHandVisible = visible;
        paintClock();
    }

    // create all the visual pieces of the clock
    private void paintClock() {
        // calculate how large the clock should be
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        // find the center of the clock
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // create a circle for the clock face
        Circle circle = new Circle(centerX, centerY, clockRadius);
        // make the inside of the clock white
        circle.setFill(Color.WHITE);
        // make the outline of the clock black
        circle.setStroke(Color.BLACK);

        // create the 12, 9, 3, 6 on the clock
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // determine how long the second hand should be
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
            Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
            Math.cos(second * (2 * Math.PI / 60));
        // make it a line
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        // make it red
        sLine.setStroke(Color.RED);

        // make the minute hand shorter than the second hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
            Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
            Math.cos(minute * (2 * Math.PI / 60));
        // make it a line
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        // make it blue
        mLine.setStroke(Color.BLUE);

        // make the hour hand the shortest
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
            Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
            Math.cos((hour % 12 + minute / 60.0) * (2 + Math.PI / 12));
        // make it a line
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        // make it green
        hLine.setStroke(Color.GREEN);

        // remove everything inside the pane
        getChildren().clear();
        // add the clock face and the 4 numbers to the pane
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);

        if (secondHandVisible) {
            getChildren().add(sLine);
        }

        if (minuteHandVisible) {
            getChildren().add(mLine);
        }

        if (hourHandVisible) {
            getChildren().add(hLine);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setHeight(height);
        paintClock();
    }
}
