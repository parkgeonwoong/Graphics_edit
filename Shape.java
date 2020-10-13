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
	
//	���� �̵��� ������ Ŭ�� �Ͽ����� Check_in, Check_out Ȯ��
	public boolean isIn(int tx, int ty) { 	
		if(x < tx && tx < x+w) {
			if(y < ty && ty < y+h) {
				return true;
			}
		}
		
		return false;
	}
}
