class Stu{
	private String name;
	private int kor,eng;
	
	Stu(){
		this.name = "제민";
		this.kor=25;
		this.eng=95;
	}
	Stu(String s){
		this.name = s;
		this.kor=45;
		this.eng=63;
	}
	Stu(String s, int i){
		this.name = s;
		this.kor = i;
		this.eng=60;
	}
	void display() {
		System.out.println(name+","+kor+","+eng);
	}
}

public class Ex05_16_객체배열 {
	public static void main(String[] args) {
		Stu s1 = new Stu();
		Stu s2 = new Stu("서현");
		Stu s3 = new Stu("수영",33);
		s1.display();
		s2.display();
		s3.display();
		
		System.out.println();
		int a=10,b=20,c=30;
		
		int[] arr1 = new int[3];
		arr1[0]=a;
		arr1[1]=b;
		arr1[2]=c;
		int[] arr2 = {a,b,c};
		int[] arr3 = new int[] {a,b,c};
		
		Stu[] arrS1 = new Stu[3];
		arrS1[0] = new Stu();
		arrS1[1] = new Stu("서현");
		arrS1[2] = new Stu("수영",33);
		
		int i;
		for(i=1; i<arrS1.length;i++) {
			arrS1[i].display();
		}
		
		System.out.println();
		
		Stu[] arrS2 = {new Stu(),new Stu("서현"),new Stu("수영",33)};
		for(i=0; i<arrS2.length;i++) {
			arrS2[i].display();
		}
	}
}