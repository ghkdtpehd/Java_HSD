import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws IOException {
		//소수. 1을제외한 1과 자신만으로 나뉘는 수
		int input;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("최대수를 입력해주세요.");
		
		input = Integer.parseInt(read.readLine());
		
		System.out.print("소수 : ");
		int stack = 3;
		System.out.print("1 2 3 ");
		for(int i=2;input>i;i++) {
			if(0!=i%2) {
				if(0!=i%3) {
					System.out.print(i+" ");
					stack++;
				}
			}
		}
		System.out.println();
		System.out.print("0부터 "+input+"사이의 소수의 개수는 "+stack+"개 입니다.");
	}

}
