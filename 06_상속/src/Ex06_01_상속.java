class Sports{
	String name;
	int inwon;
	
	void display() {
		System.out.println("�̸�: "+name);
		System.out.println("�ο�: "+inwon);
	}
}
class Baseball extends Sports{
//	String name;
//	int inwon;
	double ta;
	Baseball(String name,int inwon,double ta){
		this.name = name;
		this.inwon = inwon;
		this.ta = ta;
	}
	
	void display() {
//		System.out.println("�̸� :"+name);
//		System.out.println("�ο� :"+inwon);
		super.display();
		System.out.println("Ÿ�� :"+ta);
	}
}

class Football extends Sports{
//	String name;
//	int inwon;
	int goal;
	
	Football(String name,int inwon,int goal){
//		this.name = name;
//		this.inwon = inwon;
		super.display();
		this.goal = goal;
	}
	
	void display() {
		System.out.println("�̸� :"+name);
		System.out.println("�ο� :"+inwon);
		System.out.println("��� :"+goal);
	}
}
//�������̵�:	�θ�� �޼��带 �ڽĿ��� �����ִ� ��
//�����ε�:	�ϳ��� Ŭ���� ���� ���� �̸��� �޼��� 2�� �̻��ΰ�
public class Ex06_01_��� {
	public static void main(String[] args) {
		Baseball bb = new Baseball("�߱�",9,0.234);
		bb.display();
		
		System.out.println();
		
		Football fb = new Football("�౸",11,4);
		fb.display();
	}
}