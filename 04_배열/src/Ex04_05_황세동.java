import java.util.Scanner;

public class Ex04_05_황세동 {
	public static void main(String[] args) {
		//정수 넣을수 있는 방 5개 크기의 배열 만들고
		//배열에 숫자 입력받아 넣고
		//숫자의 총합,평균(소숫점2자리)출력
		//최대값 최소값 구하기
		
		int[] arr = new int[5];
		
		int total=0,max,min;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.print("숫자를 입력해주세요:");
			arr[i]=sc.nextInt();
		}
		
		max = arr[0];
		min = arr[0];
		
		for(int i=0;i<arr.length;i++) {
			total+=arr[i];
			if(max<arr[i]) max = arr[i];
			if(min>arr[i]) min = arr[i];
		}
		
		avg = (double)total/arr.length;
		
		System.out.println("총합: "+total);
		System.out.printf("평균: %.2f\n",avg);
		System.out.println("최대: "+max);
		System.out.println("최소: "+min);
		
		sc.close();
	}
}