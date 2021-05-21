public class Ex07_01_예외처리 {
	public static void main(String[] args) {
		int len = 0;
		int[] arr = {1,2,3};
		try {
			String str = "apple";
			len = str.length();
			
			for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}catch(NullPointerException e){
			System.out.println("에러");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index 초과");
		}
		
		//에러 프로그램에서 수습할수없는 오류
		//버그 프로그래머가 내는 오류
		//예외 프로그램에서 수습할 수 있는 미약한 오류
		
	}
}
