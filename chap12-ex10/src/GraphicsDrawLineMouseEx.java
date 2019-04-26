import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class GraphicsDrawLineMouseEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawLineMouseEx() {
		setTitle("drawing Line by Mouse ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String [] args) {
		new GraphicsDrawLineMouseEx();
	}
	
	// 
	// 
	class MyPanel extends JPanel {
		// 
		// 
		private Vector<Point> vStart = new Vector<Point>(); //
		private Vector<Point> vEnd = new Vector<Point>(); // 
		
		public MyPanel() {			
			//  
			// 
			//
			addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint(); // .
					vStart.add(startP); // 
				}
				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint(); //
					vEnd.add(endP); // 
					
					// �г��� �ٽ� �׸��⸦ ��û�Ѵ�. 
					repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE); // �Ķ����� �����Ѵ�.
			
			// ������ ũ�⸸ŭ ���� ���鼭 ���� �׸���.
			for(int i=0; i<vStart.size(); i++) { // vStart ������ ũ��� ������� ���� ������ ����
				Point s = vStart.elementAt(i); // ���Ϳ� ��� �ִ� �������� �˾Ƴ���.
				Point e = vEnd.elementAt(i); // ���Ϳ� ��� �ִ� ������ �˾Ƴ���.
				
				// ���������� �������� ���� �׸���.
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}
		}
	}
} 