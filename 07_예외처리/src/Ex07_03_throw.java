
public class Ex07_03_throw {
	public static void main(String[] args) {
		System.out.println("start");
		try {
			call();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void call() {
		try {
			int result = 7/0;
		}catch (Exception e){
			throw e;
		}
	}
}