import java.util.Scanner;

public class Ex03_04_switch_case {
	public static void main(String[] args) {
		String fruit;
		Scanner sc = new Scanner(System.in);
		System.out.println("과일이름 :");
		fruit = sc.next();
		
		switch(fruit) {
		case "apple":
			System.out.println("사과");
			break;
		case "banana":
			System.out.println("바나나");
			break;
		case "orenge":
			System.out.println("오랜지");
			break;
		default:
			System.out.println("여러과일");
			
		}	
		sc.close();
	}

}
