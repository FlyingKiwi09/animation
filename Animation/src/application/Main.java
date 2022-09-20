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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	float x = 50f, y = 50f;
	final ArrayList<Ball> balls = new ArrayList<Ball>();
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane border = new BorderPane();
		Pane center = new Pane();
		border.setCenter(center);
		HBox bottom = new HBox();
		border.setBottom(bottom);
		
//		Group group = new Group();
		
		// create new balls, add them to the group and the ArrayList
		for (int i = 0; i < 3; i++) {
			Ball newBall = new Ball(x*(i+1), y*(i+1));
			balls.add(newBall);
			center.getChildren().add(newBall.getCircle());
		}
		
		
		// controls
		Button pause = new Button("Pause");
		bottom.getChildren().add(pause);
		
		Button play = new Button("play");
		bottom.getChildren().add(play);
		
		
		final Scene scene = new Scene(border,400,400);
		
		
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
		
		pause.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				timeline.pause();
			}
			
		});
		
		play.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				timeline.play();
			}
			
		});
		
		
		
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
