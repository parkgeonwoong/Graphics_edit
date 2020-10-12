package hello;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {
	
	public Rect(int x, int y, int w, int h, boolean Shape_object) {
		super(x, y, w, h, Shape_object);
	}
	
	public void paint(Graphics g) {
		//g.setColor(Color.red);
		g.drawRect(x, y, w, h);
	}
}
