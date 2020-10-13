package hello;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{

	public Circle(int x, int y, int w, int h, int Shape_object, boolean fill, Color color) {
		super(x, y, w, h, Shape_object, fill, color);
	}
	
	public void paint(Graphics g) {
		if(fill == true) {
			g.setColor(color);
			g.fillOval(x, y, w, h);
		} else if (fill == false) {
			g.setColor(color);
			g.drawOval(x, y, w, h);
		}
	}
	
}
