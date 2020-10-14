package hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;

public class MyCanvas extends JPanel {
	public static Vector<Shape> s;			//벡터 shape 전역변수 s
	public static int now;					//현재 인덱스 값을 저장하는 전역변수 
	public static int X, Y, a, b, x, y;		//현재 마우스 좌표 X, Y / now의 인덱스가 들어간 x좌표 = a
	public static boolean flag = false;
	
	public static Color color = null;
	
//	생성자 
	public MyCanvas() {
		s = new Vector<Shape>();
		// s.add(new Rect(50, 80, 180, 120));
		// s.add(new Circle(50, 80, 100, 100));
	}

//	shape에서 캔버스로 넘어오면서 그림을 그린다.
	public void paint(Graphics g) {
		super.paint(g);

		for (int k = 0; k < s.size(); k++) {
			Shape s1 = (Shape) s.elementAt(k);
			s1.paint(g);
		}
	}

//	도형을 추가하는 메서드
	public void add(Shape s1) {
		s.add(s1);
		repaint();
	}

//	도형을 그릴때 마다 인덱스 값
	public Shape getShape(int n) {
		return s.elementAt(n);
	}

//	도형을 선택, 현재의 인덱스 값을 저장하는 (x, y) 좌표 또한 저장하는 기능
	public void Catch(MouseEvent e) {
		X = e.getX();
		Y = e.getY();

		for (int i = 0; i < s.size(); i++) {
			if (s.elementAt(i).isIn(X, Y)) {
				now = i;
				flag = true;
				a = s.elementAt(i).x;
				b = s.elementAt(i).y;
			}
		}
	}

//	도형을 이동 시킬때 이용하는 함수
	public void Catch_Move(MouseEvent e) {
		int dx = e.getX();				//마우스 release할때의 x의 좌표 
		int dy = e.getY();				//마우스 release할때의 y의 좌표 
//		변화량 release - pressed
		x = dx - X;
		y = dy - Y;

//		현재의 x 좌표에서 변화량 만큼 더한 값을 새로운 x 좌표에 기입
		if (flag = true) {
			s.elementAt(now).x = a + x;
			s.elementAt(now).y = b + y;
			repaint();
		}
	}
	

//	복사하는 메서드
	public void paste(MouseEvent e) {
		X = e.getX();
		Y = e.getY();

//		1) copy를 한 시점의 인덱스 값을 shape에 기입하여 그대로 모양을 본따온다.
		int x1 = s.elementAt(now).x;
		int y1 = s.elementAt(now).y;
		int w1 = s.elementAt(now).w;
		int h1 = s.elementAt(now).h;
//		2) Shape에서 1, 2로 도형의 모양을 확인한다.
		Shape s_now = s.elementAt(now);
		//int object = s.elementAt(now).Shape_object;


//		3) 조건에 맞게 도형을 그린다. 마우스 있는 좌표 그대로 X, Y / copy를 한 시점의 인덱스 값의 크기
		if(s_now.Shape_object == 1) {
		s.add(new Rect(X, Y, w1, h1, 1, s_now.fill, s_now.color));
		} else if (s_now.Shape_object == 2) {
		s.add(new Circle(X, Y, w1, h1, 2, s_now.fill, s_now.color));
		}
		repaint();
	}
	
	public void fill_Color(Color color) {
		Shape s_now = s.elementAt(now);
		s_now.fill = true;
		s_now.color = color;
	}
	
	public static void Vect_Check() {
		System.out.println("백터의 개수 : " + s.size());
		for (int i = 0; i < s.size(); i++) {
			Shape s_now = s.elementAt(i);
			System.out.println(i + ": " + "X=" + s_now.x + " " + "Y=" + s_now.y + " " + "W=" + (s_now.w + s_now.x) + " " + "H="
					+ (s_now.h + s_now.y) + "\t 도형:" + s_now.Shape_object + " 채워짐:" + s_now.fill + " 색깔:" + s_now.color);
		}
		System.out.println("현재 색깔: " + color);
	}
}
