import java.util.Scanner;

public class Ex09_12_황세동 {
	public static void main(String[] args) {
		//로또번호 맞추기
		int[] lotto = new int[6];
		int[] my = new int[6];
		int hit = 0;
		//1~45정수 난수 6개 발생
		//번호가 중복되지않게 중복체크
		
		
		for(int i=0;i<lotto.length;i++) {
			//우선 넣지말고 난수 생성
			int temp = random();
			
			for(int j=0;j<i;j++) {
				//처음부터 생성된 난수와 중복되는지 체크
				do {
					//만약 중복되었을때 난수를 다시 생성하기위하여 while를 사용
					//체크후 중복될시 j를 0으로 초기화 시켜 다시 처음부터 체크함
					if(lotto[j] == temp) {
						temp = random();
						j=0;
					}else {
					//아닐시 다음배열로 넘어감
						break;
					}
				}
				while(true);
			}
			
			//중복체크후 배열에 난수 입력
			lotto[i] = temp;
		}
		
		for(int i=0;i<lotto.length;i++) {
			System.out.println(lotto[i]);
		}
		
		
		Scanner sc = new Scanner(System.in);
		//사용자가 입력시 중복 입력 방지 넣기
		//중복된 숫자를 입력하셨습니다 00
		for(int i=0;i<my.length;i++) {
			System.out.print("숫자 "+(i+1)+":");
			int temp = sc.nextInt();
			
			//숫자 범위 제한
			if(temp<1||temp>45) {
				System.out.println("1~45 의숫자를 입력해주세요");
				i--;
				continue;
			}
			
			for(int j=0;j<i;j++) {
				//처음부터 입력된 숫자와 중복되는지 체크
				do {
					if(my[j] == temp) {
						System.out.println("중복된 숫자를 입력하셨습니다. "+(j+1));
						temp = sc.nextInt();
						j=0;
					}else {
					//아닐시 다음배열로 넘어감
						break;
					}
				}
				while(true);
			}
			my[i]=temp;
		}
		
		//맞은 개수 : 00
		// 6-1등 5-2등 4-3등 3-4등 그밑 꽝
		for(int i=0;i<lotto.length;i++) {
			for(int j=0;j<my.length;j++) {
				if(lotto[i] == my[j]) {
					hit++;
					continue;
				}
			}
		}
		
		System.out.println("맞춘 개수 : "+hit+"개");
		switch(hit) {
			case 1:
			case 2:
				System.out.println("꽝!");
				break;
			case 3:
				System.out.println("4등!");
				break;
			case 4:
				System.out.println("3등!");
				break;
			case 5:
				System.out.println("2등!");
				break;
			case 6:
				System.out.println("1등!");
				break;
		}
	}
	
	public static int random() {
		return (int) (Math.random()*45+1);
	}
}