package application;

import javafx.scene.shape.Circle;

public class Ball {
	private final Circle circle = new Circle();
	private float dx = 1.5f, dy=1.5f;
	
	// constructor
	public Ball (float x, float y) {
		this.circle.setCenterX(x);
		this.circle.setCenterY(y);
		this.circle.setRadius(30);
	}
	
	
	
	public void animate(double sceneWidth, double sceneHeight) {
		
		// keep in bounds
		if(circle.getCenterX() < circle.getRadius() || 
			circle.getCenterX() + circle.getRadius() > sceneWidth) {
			dx = -dx;
		}
		
		if(circle.getCenterY() < circle.getRadius() || 
				circle.getCenterY() + circle.getRadius() > sceneHeight) {
			dy = -dy;
		}
		
		
		// update center coordinates
		circle.setCenterX(circle.getCenterX() + dx);
		circle.setCenterY(circle.getCenterY() + dy);
	}
	
	

	// getters and setters
	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public Circle getCircle() {
		return circle;
	}
	
	
}
