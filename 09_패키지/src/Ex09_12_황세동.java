import java.util.Scanner;

public class Ex09_12_Ȳ���� {
	public static void main(String[] args) {
		//�ζǹ�ȣ ���߱�
		int[] lotto = new int[6];
		int[] my = new int[6];
		int hit = 0;
		//1~45���� ���� 6�� �߻�
		//��ȣ�� �ߺ������ʰ� �ߺ�üũ
		
		
		for(int i=0;i<lotto.length;i++) {
			//�켱 �������� ���� ����
			int temp = random();
			
			for(int j=0;j<i;j++) {
				//ó������ ������ ������ �ߺ��Ǵ��� üũ
				do {
					//���� �ߺ��Ǿ����� ������ �ٽ� �����ϱ����Ͽ� while�� ���
					//üũ�� �ߺ��ɽ� j�� 0���� �ʱ�ȭ ���� �ٽ� ó������ üũ��
					if(lotto[j] == temp) {
						temp = random();
						j=0;
					}else {
					//�ƴҽ� �����迭�� �Ѿ
						break;
					}
				}
				while(true);
			}
			
			//�ߺ�üũ�� �迭�� ���� �Է�
			lotto[i] = temp;
		}
		
		for(int i=0;i<lotto.length;i++) {
			System.out.println(lotto[i]);
		}
		
		
		Scanner sc = new Scanner(System.in);
		//����ڰ� �Է½� �ߺ� �Է� ���� �ֱ�
		//�ߺ��� ���ڸ� �Է��ϼ̽��ϴ� 00
		for(int i=0;i<my.length;i++) {
			System.out.print("���� "+(i+1)+":");
			int temp = sc.nextInt();
			
			//���� ���� ����
			if(temp<1||temp>45) {
				System.out.println("1~45 �Ǽ��ڸ� �Է����ּ���");
				i--;
				continue;
			}
			
			for(int j=0;j<i;j++) {
				//ó������ �Էµ� ���ڿ� �ߺ��Ǵ��� üũ
				do {
					if(my[j] == temp) {
						System.out.println("�ߺ��� ���ڸ� �Է��ϼ̽��ϴ�. "+(j+1));
						temp = sc.nextInt();
						j=0;
					}else {
					//�ƴҽ� �����迭�� �Ѿ
						break;
					}
				}
				while(true);
			}
			my[i]=temp;
		}
		
		//���� ���� : 00
		// 6-1�� 5-2�� 4-3�� 3-4�� �׹� ��
		for(int i=0;i<lotto.length;i++) {
			for(int j=0;j<my.length;j++) {
				if(lotto[i] == my[j]) {
					hit++;
					continue;
				}
			}
		}
		
		System.out.println("���� ���� : "+hit+"��");
		switch(hit) {
			case 1:
			case 2:
				System.out.println("��!");
				break;
			case 3:
				System.out.println("4��!");
				break;
			case 4:
				System.out.println("3��!");
				break;
			case 5:
				System.out.println("2��!");
				break;
			case 6:
				System.out.println("1��!");
				break;
		}
	}
	
	public static int random() {
		return (int) (Math.random()*45+1);
	}
}