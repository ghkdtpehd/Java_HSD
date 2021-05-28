class Horizontal extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			if(i%50==0) {
				System.out.println();
			}
		}
	}
}
class Vertical extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			if(i%50==0) {
				System.out.println();
			}
		}
	}
}
public class Ex11_06_�켱���� {
	public static void main(String[] args) {
		Horizontal h = new Horizontal();
		Vertical v = new Vertical();
		
		//�������� default �켱������ 5�̸� 1~10���� �����Ҽ� �ִ�.
		//���ڰ� 10�� �������� ������ ����.
		h.setName("ö��");
		v.setName("����");
		System.out.println(h.getPriority());
		System.out.println(v.getPriority());
		
		v.setPriority(7);

		h.start();
		v.start();
	}
}