import java.util.ArrayList;
import java.util.Scanner;

class Card{
	private String name;
	private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Card(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
}
public class Ex10_08_황세동 {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		ArrayList<Card> arr = new ArrayList<Card>();
		
		while(true) {
			String name,tel;
			boolean nameChk = false;
			
			System.out.print("1.명힘추가 2.명함삭제 3.명함수정 4.명함보기 5.종료 : ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
					System.out.print("이름을 입력해주세요 :");
					name = sc.next();
					System.out.print("전화번호을 입력해주세요 :");
					tel = sc.next();
					
					Card c = new Card(name,tel);
					arr.add(c);
					
					break;
				case 2:
					System.out.print("이름을 입력하세요 :");
					name = sc.next();
					
					for(int i=0;i<arr.size();i++) {
						if(name.equals(arr.get(i).getName())) {
							arr.remove(i);
							System.out.println("삭제되었습니다.");
							nameChk = true;
							break;
						}
					}
					
					if(!nameChk) {
						System.out.println("이름을 잘못입력하셨습니다.");
					}
					
					break;
				case 3:
					System.out.print("이름을 입력하세요 :");
					name = sc.next();
					
					for(int i=0;i<arr.size();i++) {
						if(name.equals(arr.get(i).getName())) {
							System.out.print("수정하실 전화번호는 : ");
							tel = sc.next();
							arr.get(i).setTel(tel);;
							nameChk = true;
							
							System.out.println("수정되었습니다.");
							break;
						}
					}
					if(!nameChk) {
						System.out.println("이름을 잘못입력하셨습니다.");
					}
					
					break;
				case 4:
					System.out.printf("이름 \t 전화번호\n");
					for(int i=0;i<arr.size();i++) {
						System.out.printf(arr.get(i).getName()+"\t"+arr.get(i).getTel()+"\n");
					}
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default :
					System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}