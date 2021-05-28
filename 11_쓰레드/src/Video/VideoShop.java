package Video;

import java.util.Vector;

public class VideoShop {
	private static Vector<String> v = new Vector<String>();
	
	public VideoShop() {
		v.add("�̳���");
		v.add("�����");
		v.add("�г�������");
	}
	
	public synchronized String lendVideo() throws InterruptedException{
		Thread t = Thread.currentThread();
		if(v.size() == 0) {
			System.out.println(t.getName()+" : ��ȣǥ ����");
			wait();
			System.out.println(t.getName()+" : ��������");
		}
		String str = v.remove(v.size()-1);
		return str;
	}
	
	public synchronized void returnVideo(String video) {
		v.addElement(video);
		notify();
	}
}
