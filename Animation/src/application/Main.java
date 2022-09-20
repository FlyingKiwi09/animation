package application;
	
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
	
	float x = 100f, y = 100f, dx = 1.5f, dy=1.5f;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		final Circle circle = new Circle(x,y,30);
		
		Group group = new Group(circle);
		final Scene scene = new Scene(group,400,400);
		
		
		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				// keep in bounds
				if(circle.getCenterX() < circle.getRadius() || 
						circle.getCenterX() + circle.getRadius() > scene.getWidth()) {
					dx = -dx;
				}
				
				if(circle.getCenterY() < circle.getRadius() || 
						circle.getCenterY() + circle.getRadius() > scene.getHeight()) {
					dy = -dy;
				}
				
				
				// update center coordinates
				circle.setCenterX(x+=dx);
				circle.setCenterY(y+=dy);
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
