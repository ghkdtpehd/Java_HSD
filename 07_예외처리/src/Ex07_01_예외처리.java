public class Ex07_01_����ó�� {
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
			System.out.println("����");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index �ʰ�");
		}
		
		//���� ���α׷����� �����Ҽ����� ����
		//���� ���α׷��Ӱ� ���� ����
		//���� ���α׷����� ������ �� �ִ� �̾��� ����
		
	}
}
