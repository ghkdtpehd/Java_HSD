import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Person implements Serializable{
	String name="ȫ�浿";
	int age=20;
}

public class Ex12_07_Serializable {
	public static void main(String[] args) {

		Person per = new Person();
		
		try {
			FileOutputStream fos = new FileOutputStream("file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
	
			oos.writeObject(per);
			oos.writeObject(new Date());
			oos.close();
			
			FileInputStream fis = new FileInputStream("file.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Person obj_per = (Person)ois.readObject();
			System.out.println(obj_per.name);
			System.out.println(obj_per.age);
			
			Date obj_Date = (Date)ois.readObject();
			System.out.println(obj_Date);
			
			System.out.println();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
