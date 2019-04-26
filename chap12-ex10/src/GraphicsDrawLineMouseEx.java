import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class GraphicsDrawLineMouseEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawLineMouseEx() {
		setTitle("drawing Line by Mouse 예제");
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
					
					// 패널의 다시 그리기를 요청한다. 
					repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE); // 파란색을 선택한다.
			
			// 벡터의 크기만큼 루프 돌면서 선을 그린다.
			for(int i=0; i<vStart.size(); i++) { // vStart 벡터의 크기는 만들어진 선의 개수와 동일
				Point s = vStart.elementAt(i); // 벡터에 들어 있는 시작점을 알아낸다.
				Point e = vEnd.elementAt(i); // 벡터에 들어 있는 끝점을 알아낸다.
				
				// 시작점에서 끝점까지 선을 그린다.
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}
		}
	}
} 