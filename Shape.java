package hello;

import java.awt.Graphics;

public abstract class Shape {
	int x, y, w, h;
	boolean Shape_object = true;	//true = circle , false = rect 
	
	public Shape(int x, int y, int w, int h, boolean Shape_object) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Shape_object = Shape_object;
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
