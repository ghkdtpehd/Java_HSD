class Sports{
	String name;
	int inwon;
	
	void display() {
		System.out.println("이름: "+name);
		System.out.println("인원: "+inwon);
	}
}
class Baseball extends Sports{
	double ta;
	Baseball(String name,int inwon,double ta){
		this.name = name;
		this.inwon = inwon;
		this.ta = ta;
	}
	
	void display() {
		super.display();
		System.out.println("타율 :"+ta);
	}
}

class Football extends Sports{
	int goal;
	
	Football(String name,int inwon,int goal){
		super.display();
		this.name = name;
		this.inwon = inwon;
		this.goal = goal;
	}
	
	void display() {
		System.out.println("이름 :"+name);
		System.out.println("인원 :"+inwon);
		System.out.println("골수 :"+goal);
	}
}
//오버라이딩:	부모와 메서드를 자식에게 물려주는 것
//오버로딩:	하나의 클레스 내에 같은 이름의 메서드 2개 이상인것
public class Ex06_01_상속 {
	public static void main(String[] args) {
		Baseball bb = new Baseball("야구",9,0.234);
		bb.display();
		
		System.out.println();
		
		Football fb = new Football("축구",11,4);
		fb.display();
		
		Sports[] sp = {new Baseball("야구",9,0.234),new Football("축구",11,4)};
		
		System.out.println();
		
		for (int i=0;i<sp.length;i++) {
			sp[i].display();
		}
	}
}