import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_05_DataStream {
	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("data.txt"); // 1차스트림
		DataOutputStream dos = new DataOutputStream(fos); // 2차스트림 
	
		dos.write(100); // 0~255
		dos.writeInt(100); // 
		dos.writeFloat(3.14f);
		
		dos.close();
		
		FileInputStream fis = new FileInputStream("data.txt");
		DataInputStream dis = new DataInputStream(fis);
		
		int a = dis.read();
		int b = dis.readInt();
		float c = dis.readFloat();
		dis.close();
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("c:"+c);
//		3:05 신호전송
		
	}
}





