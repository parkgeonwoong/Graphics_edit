package hello;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {
	
	public Rect(int x, int y, int w, int h, int Shape_object, boolean fill, Color color) {
		super(x, y, w, h, Shape_object, fill, color);
	}
	
	public void paint(Graphics g) {
		if(fill == true) {
			g.setColor(color);
			g.fillRect(x, y, w, h);
		} else if (fill == false) {
			g.setColor(color);
			g.drawRect(x, y, w, h);
		}
	}
}
