import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex12_11_Scanner {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("read.txt"));
		
		sc.useDelimiter(","); 
		
		int sum = 0,num,count=0;
		while(sc.hasNextInt()) {
			sum+=sc.nextInt();
			count++;
		}
		
		System.out.println("ÃÑ ÇÕ : "+sum+" / ¹Ýº¹ È¸¼ö :"+count+" / Æò±Õ : "+ ((double)sum/count));
		sc.close();
	}
}