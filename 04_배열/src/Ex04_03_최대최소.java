public class Ex04_03_�ִ��ּ� {
	public static void main(String[] args) {
		int[] score= {78,88,93,31,100,68,15};
		
		int sum=0;
		for(int i=0;i<score.length;i++) {
			System.out.print(score[i]+" ");
			sum +=score[i];
		}
		System.out.println();
		System.out.println("sum: "+sum);
		System.out.println("��� : "+sum/score.length);
		
		int max = score[0];
		int min = score[0];
		
		for(int i=1;i<score.length;i++) {
			if(max<score[i]) {
				max=score[i];
			}
			if(min>score[i]) {
				min=score[i];
			}
		}
		System.out.println("�ִ밪 : "+max);
		System.out.println("�ּҰ� : "+min);
	}
}