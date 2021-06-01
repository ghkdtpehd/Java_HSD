import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Ex13_05_sub extends Frame implements ItemListener{
	String[] 대륙 = {"아시아","유럽","아프리카"};
	String[][] 나라 = {{"한국","일본","중국"},{"영국","스위스","프랑스"},{"이집트","콩고","우간다"}};
	
	Choice ch1 = new Choice();
	Choice ch2 = new Choice();
	Label lb1 = new Label("대륙과 나라를 선택하세요");
	Label lb2 = new Label();
	
	Ex13_05_sub(String title){
		super(title);
		
		lb1.setBackground(Color.cyan);
		lb2.setBackground(Color.yellow);
		
		Panel p = new Panel();
		p.setBackground(Color.pink);
		
		
		for(int i=0;i<대륙.length;i++) {
			ch1.add(대륙[i]);
		}
		ch2.add("          ");
		
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		
		lb2.setAlignment(Label.CENTER);
		
		setSize(400,300);
		setVisible(true);
		
		super.add(lb1,BorderLayout.NORTH);
		p.add(ch1);
		p.add(ch2);
		super.add(p,BorderLayout.CENTER);
		super.add(lb2,BorderLayout.SOUTH);
		
		ch1.select(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == ch1) {
			int sel1 = ch1.getSelectedIndex();
			ch2.removeAll();
			
			for(int i=0;i<나라[sel1].length;i++) {
				ch2.add(나라[sel1][i]);
			}
		}
		lb2.setText("선택한 대륙과 나라는 : " + ch1.getSelectedItem()+", "+ ch2.getSelectedItem());
	}
}
public class Ex13_05_ItemEvent {
	public static void main(String[] args) {
		new Ex13_05_sub("초이스 이벤트");
	}
}