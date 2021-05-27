import java.util.HashMap;
import java.util.Scanner;

class Movie{
	private String title;
	private int age;
	public Movie(String title, int age) {
		this.title = title;
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return title + " / " + age;
	}
}
public class Ex10_13_HashMap {
	public static void main(String[] args) {
		HashMap<String, Movie> movie = new HashMap<String, Movie>();
		Movie m1 = new Movie("�г��� ����",15);
		Movie m2 = new Movie("�̳���",12);
		Movie m3 = new Movie("��Ž���ڳ�",19);
		
		movie.put("CGV",m1);
		movie.put("�Դ�ó׸�",m2);
		movie.put("�ް��ڽ�",m3);
		movie.put("�������",new Movie("���󿡸�",7));
		
		System.out.println("movie : "+ movie);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ȭ�� :");
		String theater = sc.next();
		if(movie.get(theater)==null) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}else {
			System.out.println(movie.get(theater));
		}
		
		Movie m4 = new Movie("�����",12);
		movie.replace("�������", m4);
		System.out.println("���� ��: " + movie);
		System.out.println(movie.size());
		
		System.out.println(movie.isEmpty());
		movie.remove("�������");
		System.out.println(movie.size());
		
		movie.clear();
		System.out.println(movie.size());
		System.out.println(movie.isEmpty());
		
	}
}