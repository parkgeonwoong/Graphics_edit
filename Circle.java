package hello;

import java.awt.Graphics;

public class Circle extends Shape{

	public Circle(int x, int y, int w, int h, boolean Shape_object) {
		super(x, y, w, h, Shape_object);
	}
	
	public void paint(Graphics g) {
		g.drawOval(x, y, w, h);
	}
	
}
