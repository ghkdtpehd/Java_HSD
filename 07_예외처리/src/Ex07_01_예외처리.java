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
			
			System.out.println(3/0);
		}catch(NullPointerException e){
			System.out.println("����");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index �ʰ�");
		}catch (Exception e) {
			System.out.println("error");
		}
		
		//���� ���α׷����� �����Ҽ����� ����
		//���� ���α׷��Ӱ� ���� ����
		//���� ���α׷����� ������ �� �ִ� �̾��� ����
		
	}
}
