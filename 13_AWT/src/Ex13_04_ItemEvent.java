import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Ex13_04_sub extends Frame implements ItemListener{
	List list = new List(3,true);
	Choice ch = new Choice();
	
	{
		list.add("������");
		list.add("�Ѷ��");
		list.add("������");
		list.add("�ݰ���");
		list.add("�Ӹ���");
		
		ch.add("���޷�");
		ch.add("����");
		ch.add("���");
		ch.add("��ȭ");
		ch.add("������");
	}
	
	Ex13_04_sub(){
		setLayout(new FlowLayout());
		
		list.addItemListener(this);
		ch.addItemListener(this);
		
		
		super.add(list);
		super.add(ch);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == list) {
			int[] index_arr = list.getSelectedIndexes();
			String[] item_arr = list.getSelectedItems();
			for(int i=0;i<index_arr.length;i++) {
				System.out.print(index_arr[i]+" : "+item_arr[i]+"/");
			}
			System.out.println();
		}else if(obj == this.ch){
			System.out.println(ch.getSelectedIndex()+": "+ch.getSelectedItem());
		}
			
	}
	
}
public class Ex13_04_ItemEvent {
	public static void main(String[] args) {
		Ex13_04_sub sub = new Ex13_04_sub();
		sub.setTitle("ItemEvent");
		
		sub.setSize(500,350);
		sub.setVisible(true);
	}
}