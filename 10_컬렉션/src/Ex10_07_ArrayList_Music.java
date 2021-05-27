import java.util.ArrayList;
import java.util.Scanner;

class Music{
	private String title;
	private String singer;
	private int price;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Music(String title, String singer, int price) {
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
	
	public String toString() {
		return title+" / "+singer+" / "+price;
	}
}
public class Ex10_07_ArrayList_Music {
	public static void main(String[] args) {
		ArrayList<Music> arr = new ArrayList<Music>();
		
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			String title,singer;
			int price;
			
			System.out.print("노래 제목 :");		
			title = sc.next();
			System.out.print("가수 이름 :");
			singer = sc.next();
			System.out.print("노래 가격 :");
			price = sc.nextInt();
			
			Music m = new Music(title,singer,price);
			
			arr.add(m);
			
			System.out.println("끝내시겠습니까? Y/N");
			String anser = sc.next();
			
			if(anser.equals("y")||anser.equals("Y")) {
				break;
			}
		}
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
		while(true) {
			boolean chk = false;
			System.out.print("찾는 제목 : ");
			String search_title = sc.next();
			for(int i=0; i<arr.size();i++) {
				if(arr.get(i).getTitle().equals(search_title)) {
					System.out.println(search_title+"의 가수 이름은 "+arr.get(i).getSinger()+" 입니다.");
					chk = true;
					break;
				}
			}
			
			if(!chk) {
				System.out.println("찾는 제목이 없습니다.");
			}
			
			System.out.println("끝내시겠습니까? Y/N");
			String anser = sc.next();
			
			if(anser.equals("y")||anser.equals("Y")) {
				break;
			}
		}
		
		sc.close();
	}
}