class ThreadRun implements Runnable{

	public void run() {
		for(int i=1;i<=50;i++) {
			System.out.print(i+" ");
		}
	}
	
}
public class Ex11_01_Thread {
	public static void main(String[] args) {
		System.out.println("����");
		
		ThreadRun t = new ThreadRun();
//		t.run();
		Thread trd = new Thread(t);
		trd.start();
		
		System.out.println("����");
	}
}

//������ : ���μ����� �����ϴ� ���� ���� ����
//��Ƽ ������ : �����带 ���ÿ� �����ְ� �ϴ°�
//������ �������̽� �Ǵ� Ŭ������ ��ӹ޾ƾ� �ϸ� run()�� �������̵� �Ͽ����Ѵ�