package hello;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Test2 extends JFrame {

	private JPanel contentPane;
	private MyCanvas myCanvas;

	int mode;					// click btn�� ����
	int x, y, X, Y;
	int w, h, W, H;

	
/////Main ///////
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 frame = new Test2();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test2() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Graphics_Edit");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\a0506\\eclipse-workspace\\2020\\diagram.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 660);

		//////// MenuBar ////////
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clear");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myCanvas.s.clear();
				myCanvas.repaint();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		
//		Edit_Color/Check_Color
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Yellow");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 6;
				myCanvas.color = Color.yellow;
				myCanvas.repaint();
				System.out.println("yello ���� ��");
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Vect_Check");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCanvas.Vect_Check();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Blue");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 6;
				myCanvas.color = Color.blue;
				myCanvas.repaint();
				System.out.println("Blue ���� ��");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Red");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 6;
				myCanvas.color = Color.red;
				myCanvas.repaint();
				System.out.println("Red ���� ��");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Orange");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 6;
				myCanvas.color = Color.orange;
				myCanvas.repaint();
				System.out.println("Orange ���� ��");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Pink");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 6;
				myCanvas.color = Color.pink;
				myCanvas.repaint();
				System.out.println("Pink ���� ��");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Black");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 6;
				myCanvas.color = Color.black;
				myCanvas.repaint();
				System.out.println("Black ���� ��");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);

		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Info");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] mesg = { "������ : 173312_�ڰǿ�" };
				JOptionPane.showMessageDialog(Test2.this, mesg, "����", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		/////// MyCanvas ///////
		myCanvas = new MyCanvas();
		myCanvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			
//		mouseDragged
			public void mouseDragged(MouseEvent e) {
				Graphics g = myCanvas.getGraphics(); 		//mycanvas�� �׷����� ���´�.
				g.setXORMode(Color.DARK_GRAY);
				//g.setXORMode(myCanvas.getBackground());

				X = e.getX();
				Y = e.getY();
// 		���콺 �巡�׸� ��𼭵� �� �� �ִ� ��ǥ ����
				if (x > X) {
					W = X;
					w = x - X;
				} else {
					W = x;
					w = X - x;
				}
				if (y > Y) {
					H = Y;
					h = y - Y;
				} else {
					H = y;
					h = Y - y;
				}
//			���ǿ� �°� ������ �׸�
				if (mode == 1) {
					g.drawOval(x, y, w, h);
				} else if (mode == 2) {
					g.drawRect(x, y, w, h);
				} else if (mode == 0) {
					myCanvas.Catch_Move(e);
				} 
				g.setPaintMode();
				repaint();
			}

		});
		myCanvas.addMouseListener(new MouseAdapter() {
			@Override
			
//		mouseClick
			public void mouseClicked(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
			}
//		mousePressed
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();

				if (mode == 0) {			//������ �̵� ��ų �� ������ �ε����� �����ϱ� ���Ѱ�
					myCanvas.Catch(e);			
				} else if (mode == 3) {		//copy�� �ϱ� ���� �ε��� ����
					myCanvas.Catch(e);
					System.out.println("COPY_Check");
				} else if (mode == 4) {		//paste �޼��� �۵�
					myCanvas.paste(e);
					System.out.println("PASTE_Check");
				} 
			}
//		mouseReleased
			@Override
			public void mouseReleased(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
//		 		���콺�� �����Ӱ� �׸��� ���� ���� 
				if (x > X) {
					W = X;
					w = x - X;
				} else {
					W = x;
					w = X - x;
				}
				if (y > Y) {
					H = Y;
					h = y - Y;
				} else {
					H = y;
					h = Y - y;
				}
				
				System.out.println("x��ǥ :"+x + " y��ǥ :"+ y + " X��ǥ:" + X + " Y��ǥ:"+ Y );
				System.out.println("w��ǥ :"+w + " h��ǥ :"+ h + " W��ǥ:" + W + " H��ǥ:"+ H );
				
				if (mode == 1) {
					myCanvas.add(new Circle(x, y, w, h, 2, false, Color.black));
				} else if (mode == 2) {
					myCanvas.add(new Rect(x, y, w, h, 1, false, Color.black));
				} else if (mode == 6) {		//���õ� ������ �� ��ȭ
					myCanvas.Catch(e);
					myCanvas.fill_Color(myCanvas.color);
					myCanvas.repaint();
				}
			}
		});

		myCanvas.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(myCanvas, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
						.addComponent(myCanvas, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		///// ��ư ��� /////
//		1.Circle ��ư
		JButton btnCircle = new JButton("");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 1;
			}
		});
		btnCircle.setIcon(
				new ImageIcon("C:\\Users\\a0506\\eclipse-workspace\\2020\\clean.png"));

//		2.Rect ��ư
		JButton btnRect = new JButton("");
		btnRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 2;
			}
		});
		btnRect.setIcon(
				new ImageIcon("C:\\Users\\a0506\\eclipse-workspace\\2020\\rectangle.png"));

//		3.Arrow ��ư
		JButton btnArrow = new JButton("");
		btnArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mode = 0;
			}
		});
		btnArrow.setIcon(
				new ImageIcon("C:\\Users\\a0506\\eclipse-workspace\\2020\\arrow.png"));
		
//		4.Copy ��ư
		JButton btnCopy = new JButton("");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode = 3;
			}
		});
		btnCopy.setIcon(new ImageIcon("C:\\Users\\a0506\\eclipse-workspace\\2020\\copy.png"));
		
//		5. Paste ��ư
		JButton btnPaste = new JButton("");
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode = 4;
			}
		});
		btnPaste.setIcon(new ImageIcon("C:\\Users\\a0506\\eclipse-workspace\\2020\\paste.png"));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnArrow, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnRect, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnCircle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnCopy, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(btnPaste, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnCircle, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRect, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnArrow, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCopy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPaste, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public MyCanvas getMyCanvas() {
		return myCanvas;
	}
}
