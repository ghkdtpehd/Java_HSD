package Video;

public class Person extends Thread{
	Person(String name){
		super(name);
	}
	public void run() {
		try {
			String video = ThreadMain.vShop.lendVideo();
			System.out.println(getName()+" : "+video+" ���Ǵ�.");
			System.out.println(getName()+" : "+video+" ������.");
		
			sleep(3000);
		
			System.out.println(getName()+" : "+video+" �ݳ�.");
			
			ThreadMain.vShop.returnVideo(video);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
