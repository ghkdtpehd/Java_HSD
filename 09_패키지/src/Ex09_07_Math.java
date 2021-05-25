public class Ex09_07_Math {
	public static void main(String[] args) {
		System.out.println("큰수 : "+Math.max(10,20));
		
		System.out.println("3~9 난수 : "+(int)(Math.random()*7+3));
		
		//반올림
		System.out.println(Math.round(3.8));
		System.out.println(Math.round(3.2));
		
		//올림
		System.out.println(Math.ceil(3.2));
		//버림
		System.out.println(Math.floor(3.8));
		//x의y승
		System.out.println(Math.pow(2,3));
		
		//import Math 하면 Math 를 생략할수있다.
	}
}