package application;
	
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	float x = 50f, y = 50f;
	final ArrayList<Ball> balls = new ArrayList<Ball>();
	
	@Override
	public void start(Stage primaryStage) {
		
		Group group = new Group();
		
		// create new balls, add them to the group and the ArrayList
		for (int i = 0; i < 3; i++) {
			Ball newBall = new Ball(x*(i+1), y*(i+1));
			balls.add(newBall);
			group.getChildren().add(newBall.getCircle());
		}
		
		
		final Scene scene = new Scene(group,400,400);
		
		
		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// animate each of the balls in the arraylist
				for (int i = 0; i < balls.size(); i++) {					
					balls.get(i).animate(scene.getWidth(), scene.getHeight());
				}
			}
		});
		
		
		Timeline timeline = new Timeline();
		timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
		timeline.getKeyFrames().add(frame);
		timeline.play();
		
//		timeline.stop();
//		timeline.pause();

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Hello Annimation");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
