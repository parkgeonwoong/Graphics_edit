package hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;

public class MyCanvas extends JPanel {
	public static Vector<Shape> s;			//���� shape �������� s
	public static int now;					//���� �ε��� ���� �����ϴ� �������� 
	public static int X, Y, a, b, x, y;		//���� ���콺 ��ǥ X, Y / now�� �ε����� �� x��ǥ = a
	public static boolean flag = false;
	
	public static Color color = null;
	
//	������ 
	public MyCanvas() {
		s = new Vector<Shape>();
		// s.add(new Rect(50, 80, 180, 120));
		// s.add(new Circle(50, 80, 100, 100));
	}

//	shape���� ĵ������ �Ѿ���鼭 �׸��� �׸���.
	public void paint(Graphics g) {
		super.paint(g);

		for (int k = 0; k < s.size(); k++) {
			Shape s1 = (Shape) s.elementAt(k);
			s1.paint(g);
		}
	}

//	������ �߰��ϴ� �޼���
	public void add(Shape s1) {
		s.add(s1);
		repaint();
	}

//	������ �׸��� ���� �ε��� ��
	public Shape getShape(int n) {
		return s.elementAt(n);
	}

//	������ ����, ������ �ε��� ���� �����ϴ� (x, y) ��ǥ ���� �����ϴ� ���
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

//	������ �̵� ��ų�� �̿��ϴ� �Լ�
	public void Catch_Move(MouseEvent e) {
		int dx = e.getX();				//���콺 release�Ҷ��� x�� ��ǥ 
		int dy = e.getY();				//���콺 release�Ҷ��� y�� ��ǥ 
//		��ȭ�� release - pressed
		x = dx - X;
		y = dy - Y;

//		������ x ��ǥ���� ��ȭ�� ��ŭ ���� ���� ���ο� x ��ǥ�� ����
		if (flag = true) {
			s.elementAt(now).x = a + x;
			s.elementAt(now).y = b + y;
			repaint();
		}
	}
	

//	�����ϴ� �޼���
	public void paste(MouseEvent e) {
		X = e.getX();
		Y = e.getY();

//		1) copy�� �� ������ �ε��� ���� shape�� �����Ͽ� �״�� ����� �����´�.
		int x1 = s.elementAt(now).x;
		int y1 = s.elementAt(now).y;
		int w1 = s.elementAt(now).w;
		int h1 = s.elementAt(now).h;
//		2) Shape���� 1, 2�� ������ ����� Ȯ���Ѵ�.
		Shape s_now = s.elementAt(now);
		//int object = s.elementAt(now).Shape_object;


//		3) ���ǿ� �°� ������ �׸���. ���콺 �ִ� ��ǥ �״�� X, Y / copy�� �� ������ �ε��� ���� ũ��
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
		System.out.println("������ ���� : " + s.size());
		for (int i = 0; i < s.size(); i++) {
			Shape s_now = s.elementAt(i);
			System.out.println(i + ": " + "X=" + s_now.x + " " + "Y=" + s_now.y + " " + "W=" + (s_now.w + s_now.x) + " " + "H="
					+ (s_now.h + s_now.y) + "\t ����:" + s_now.Shape_object + " ä����:" + s_now.fill + " ����:" + s_now.color);
		}
		System.out.println("���� ����: " + color);
	}
}
