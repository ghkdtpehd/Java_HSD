
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
		 cmd 에서 실행
		  
		 C:\Java_hsd\01_자료형과 기본입출력\src>javac Ex01_print.java    -- 기계어로 변환 .class 파일 생성
		 
		 C:\Java_hsd\01_자료형과 기본입출력\src>java Ex01_print
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
		System.out.printf("a=%d\n",a); //format 문자 (정수: %d)
		System.out.printf("b=%c\n",b);
		System.out.printf("b=%5d\n",(int)b); //%5d 5개의 자리 표시
		
		System.out.printf("c=%f\n",c);
		System.out.printf("c=%.2f\n",c); //%.n 소숫점 자리수를 n까지만 표시한다.
		
		System.out.println("안녕하세요\n저의\"이름\"은'홍길동'\t입니다.");
	}
}
