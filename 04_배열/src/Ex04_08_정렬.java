public class Ex04_08_Á¤·Ä {
	public static void main(String[] args) {
		int[] arr = {8,3,5,2,9};
		
		int temp; 
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
			/*
			for(int x:arr)
				System.out.print(x+" ");
			System.out.println();
			*/
		}
		
		for(int x:arr)
		System.out.print(x+" ");
	}
}