package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UsingTranslate extends Application {
	
	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;
//	double tv = 1;
	

	@Override
	public void start(Stage primaryStage) {
		
		final Circle circle = new Circle(0,0,30);
		
		Group group = new Group(circle);
		final Scene scene = new Scene(group,400,400);
		
		
		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				// keep in bounds
				if(circle.getTranslateX() < circle.getRadius() || 
						circle.getTranslateX() + circle.getRadius() > scene.getWidth()) {
					dx = -dx;
				}
				
				if(circle.getTranslateY() < circle.getRadius() || 
						circle.getTranslateY() + circle.getRadius() > scene.getHeight()) {
					dy = -dy;
				}
				
				
				// update center coordinates
				circle.setTranslateX(x+=dx);
				circle.setTranslateY(y+=dy);

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
		Application.launch(args);

	}

}
