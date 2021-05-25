import java.util.Scanner;

class Person {
	String id;
	String pw;
	String name;

	public Person(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}

public class Ex09_04_황세동 {
	public static void main(String[] args) {
		// Person 객체 3개 배열로 생성

		Person[] p = { new Person("joo1", "qwe23", "주원"),
				new Person("wj355", "q1w2e3", "원경"),
				new Person("kimgh", "qwe123", "경호") };
		Scanner sc = new Scanner(System.in);

		do {
			//변수 정의
			String id = "", pw = "", result = "";
			boolean idChk = false,pwChk=false;
			Person token = null;

			//id값 받기
			System.out.print("id 입력 :");
			id = sc.next();
			
			//아이디 허용값 초과 확인
			if (id.length() > 8 || id.length() < 3) {
				System.out.println("아이디는 3~8글자를 입력해야 합니다.");
				continue;
			}
			
			//아이디 확인, 해당 배열 뽑아오기
			//해당아이디가 뒷 배열에 있을 경우 중복하여 출력하여서 뒤로 뺌
			for (int i = 0; i < p.length; i++) {
				if (p[i].id.equals(id)) {
					// id 매칭 완료
					idChk = true;
					token = p[i];
				}
			}

			// 아이디가 없을떄
			if (idChk == false) {
				System.out.println("해당 아이디가 없습니다.");
				
				//지속여부 확인
				System.out.print("계속 하시겠습니까? Y/N");
				result = sc.next();
				
				if(result.equals("n")||result.equals("N")) {
					break;
				}else {
					continue;
				}
			}
			
			//비밀번호 입력
			System.out.print("pw 입력 :");
			pw = sc.next();
			
			//비밀번호 확인, 성공시 로그출력
			for(int i = 0; i<p.length;i++) {
				if(token.pw.equals(pw)) {
					pwChk=true;
				}
			}
			
			//비밀번호가 없을시 출력
			if(!pwChk) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}else {
				System.out.println(token.name+"님 반갑습니다.");
			}
			
			//지속 확인
			System.out.print("계속 하시겠습니까?");
			result = sc.next();
			
			if (result.equals("n")||result.equals("N")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} while (true);
		
		sc.close();
	}
}