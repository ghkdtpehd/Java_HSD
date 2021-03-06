class Music{
	private String title; 
	private String singer;
	private String genre;
	private int price;
	
	Music(){
		title = "상상더하기";
		singer = "라붐";
		genre = "KPOP";
		price = 2500;
	}
	Music(String t,String s,String g,int p){
		title = t;
		singer = s;
		genre = g;
		price = p;
	}
	
	//setter
	void setTitle(String title) {this.title = title;}
	void setSinger(String singer) {this.singer = singer;}
	void setGenre(String genre) {this.genre = genre;}
	void setPrice(int price) {this.price = price;}
	//getter
	String getTitle() {return title;}
	String getSinger() {return singer;}
	String getGenre() {return genre;}
	int getPrice() {return price;}
	
	void display() {
		System.out.println(this.title+", "+this.singer+", "+this.genre+", "+this.price);
	}
}
public class Ex05_15_황세동 {
	public static void main(String[] args) {
		//m1 한번에 출력하는 메서드
		//m2 m3 getter로 출력
		
		Music m1 = new Music(); //생성자를 통한 주입
		System.out.println(m1.getTitle()+", "+m1.getSinger()+", "+m1.getGenre()+", "+m1.getPrice());
		
		System.out.println();
		
		Music m2 = new Music("롤린","브레이브걸스","댄스",3000);
		System.out.println(m2.getTitle()+", "+m2.getSinger()+", "+m2.getGenre()+", "+m2.getPrice());
		
		System.out.println();
		
		Music m3 = new Music();//setter를 통합 주입
		m3.setTitle("라일락");
		m3.setSinger("아이유");
		m3.setGenre("발라드");
		m3.setPrice(4000);
		System.out.println(m3.getTitle()+", "+m3.getSinger()+", "+m3.getGenre()+", "+m3.getPrice());
		
		System.out.println();
		System.out.println("--2과제--");
		//객체배열로 만들기
		//m1 한번에 한줄로 출력
		//m2 m3 getter로 출력
		Music[] arrM = new Music[3];
		arrM[0] = m1;
		arrM[1] = m2;
		arrM[2] = m3;
		
		arrM[0].display();
		System.out.println(arrM[1].getTitle()+", "+arrM[1].getSinger()+", "+arrM[1].getGenre()+", "+arrM[1].getPrice());
		System.out.println(arrM[2].getTitle()+", "+arrM[2].getSinger()+", "+arrM[2].getGenre()+", "+arrM[2].getPrice());
	}
}