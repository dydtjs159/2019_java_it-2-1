import javax.swing.*;
import java.awt.event.*;
import java.awt.*;      

public class CheckBoxItemEventEx extends JFrame {
	private JCheckBox [] fruits = new JCheckBox [3]; // 
	private String [] names = {"수박", "딸기", "참외"}; // 
	private JLabel sumLabel; // 
	
	public CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("수박9500원, 딸기 5000원, 참외 5000원"));
		
		// 
		MyItemListener listener = new MyItemListener();
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]); // 
			fruits[i].setBorderPainted(true); // 
			c.add(fruits[i]); // 
			fruits[i].addItemListener(listener); // 
		}
		
		sumLabel = new JLabel("현재 0 원 입니다."); // 
		c.add(sumLabel);
		
		setSize(250,200);
		setVisible(true);
	}
	
	// 
	class MyItemListener implements ItemListener {
		private int sum = 0; // 

		//
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) { // 
				if(e.getItem() == fruits[0]) // 
					sum += 9500;
				else if(e.getItem() == fruits[1]) // 
					sum += 5000;
				else // 
					sum += 5000;
			}
			else { // 
				if(e.getItem() == fruits[0]) // 
					sum -= 9500;
				else if(e.getItem() == fruits[1]) // 
					sum -= 5000;
				else // 
					sum -= 5000;
			}
			sumLabel.setText("현재 "+ sum + "원 입니다."); // 
		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
} 