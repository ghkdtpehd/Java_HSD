package Video;

public class Person extends Thread{
	Person(String name){
		super(name);
	}
	public void run() {
		try {
			String video = ThreadMain.vShop.lendVideo();
			System.out.println(getName()+" : "+video+" ºô·Ç´Ù.");
			System.out.println(getName()+" : "+video+" º¸´ÂÁß.");
		
			sleep(3000);
		
			System.out.println(getName()+" : "+video+" ¹Ý³³.");
			
			ThreadMain.vShop.returnVideo(video);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
