import java.io.File;

public class Ex12_02_File {
	public static void main(String[] args) {
		File f = new File("C:\\windows\\");
		System.out.println("f:"+f);
		
		boolean result = f.isDirectory();
		
		String resultT1 = result ? "����":"����";
		System.out.println("resultT1 : "+resultT1);
		
		String resultT2 = f.isDirectory() ? "����":"����";
		System.out.println("resultT2 : "+resultT2);
		
		String[] lists = f.list();
		System.out.println(lists.length);
		
		for(int i=0;i<lists.length;i++) {
			File kind = new File(f,lists[i]);
			if(kind.isFile()) {
				System.out.println("���� :"+lists[i]);
			}else {
				System.out.println("���� :"+lists[i]);
			}
		}
	}
}