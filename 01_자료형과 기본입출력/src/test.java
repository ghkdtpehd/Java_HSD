import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws IOException {
		//�Ҽ�. 1�������� 1�� �ڽŸ����� ������ ��
		int input;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�ִ���� �Է����ּ���.");
		
		input = Integer.parseInt(read.readLine());
		
		System.out.print("�Ҽ� : ");
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
		System.out.print("0���� "+input+"������ �Ҽ��� ������ "+stack+"�� �Դϴ�.");
	}

}
