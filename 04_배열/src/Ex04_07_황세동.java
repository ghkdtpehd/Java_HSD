import java.util.Scanner;

public class Ex04_07_황세동 {
	public static void main(String[] args) {
		//2 3배열 생성
		//스캐너로 입력
		//0~1행의 합
		//0~2열의 합
		//전체의 합
		int [][] arr = new int[2][3];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("숫자를"+i+1+"행의 입력해주세요");
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(i+1+"행"+(j+1)+"열: ");
				arr[i][j]=sc.nextInt();
			}
		}
		
		int totalH0=0,totalH1=0,totalV0=0,totalV1=0,totalV2=0,total=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				//행의 합
				if(i==0) totalH0+=arr[i][j];
				if(i==1) totalH1+=arr[i][j];
				//열의 합
				if(j==0) totalV0+=arr[i][j];
				if(j==1) totalV1+=arr[i][j];
				if(j==2) totalV2+=arr[i][j];
				//모두의 합
				total+=arr[i][j];
			}
		}
		
		System.out.println("-----------");
		System.out.println("1행의 합 :"+totalH0);
		System.out.println("2행의 합 :"+totalH1);
		System.out.println();
		System.out.println("1열의 합 :"+totalV0);
		System.out.println("2열의 합 :"+totalV1);
		System.out.println("3열의 합 :"+totalV2);
		System.out.println();
		System.out.println("총 합 :"+total);
	}
}