
public class Ex01_01_print {
	public static void main(String[] args) {
		System.out.println(10);
		System.out.println(20);
		System.out.println(10+20);
		System.out.println('a');
		System.out.println("a");
		//System.out.println('asd');
		System.out.println("asd");
		System.out.println("30");
		System.out.println("10+20");
		System.out.println(' ');
		System.out.println("");
		System.out.println("ab"+"xy");
		System.out.println("10"+"20");
		System.out.println("10+20="+10+20);
		System.out.println("10+20="+(10+20));
		
		/*
		 cmd ���� ����
		  
		 C:\Java_hsd\01_�ڷ����� �⺻�����\src>javac Ex01_print.java    -- ����� ��ȯ .class ���� ����
		 
		 C:\Java_hsd\01_�ڷ����� �⺻�����\src>java Ex01_print
		 10
		 20
		 30
		 a
		 a
		 asd
		 30
		 10+20
         
         
		 abxy
		 1020
		 10+20=30
		 */
		
		int a = 100;
		char b = 'A';
		float c = 12.987f;
		
		System.out.println("a="+a);
		System.out.printf("a=%d\n",a); //format ���� (����: %d)
		System.out.printf("b=%c\n",b);
		System.out.printf("b=%5d\n",(int)b); //%5d 5���� �ڸ� ǥ��
		
		System.out.printf("c=%f\n",c);
		System.out.printf("c=%.2f\n",c); //%.n �Ҽ��� �ڸ����� n������ ǥ���Ѵ�.
		
		System.out.println("�ȳ��ϼ���\n����\"�̸�\"��'ȫ�浿'\t�Դϴ�.");
	}
}
