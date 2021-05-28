package Video;

import java.util.Vector;

public class VideoShop {
	private static Vector<String> v = new Vector<String>();
	
	public VideoShop() {
		v.add("미나리");
		v.add("어벤져스");
		v.add("분노의질주");
	}
	
	public synchronized String lendVideo() throws InterruptedException{
		Thread t = Thread.currentThread();
		if(v.size() == 0) {
			System.out.println(t.getName()+" : 번호표 받음");
			wait();
			System.out.println(t.getName()+" : 다음순서");
		}
		String str = v.remove(v.size()-1);
		return str;
	}
	
	public synchronized void returnVideo(String video) {
		v.addElement(video);
		notify();
	}
}
