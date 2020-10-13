package hello;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	public int x, y, w, h;
	public int Shape_object;	//1 = rect  , 2 = circle 
	public boolean fill;
	public Color color;
	
	
	public Shape(int x, int y, int w, int h, int Shape_object, boolean fill, Color color) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Shape_object = Shape_object;
		this.fill = fill;
		this.color = color;
	}
	
	
	public abstract void paint(Graphics g);
	
//	도형 이동시 도형을 클릭 하였을때 Check_in, Check_out 확인
	public boolean isIn(int tx, int ty) { 	
		if(x < tx && tx < x+w) {
			if(y < ty && ty < y+h) {
				return true;
			}
		}
		
		return false;
	}
}
