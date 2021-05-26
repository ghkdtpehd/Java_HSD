import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_11_Date_SimpleDateFormat {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now.getYear()+1900+"��");
		System.out.println(now.getMonth()+1+"��");
		System.out.println(now.getDate()+"��");
		
		String[] week = {"��","��","ȭ","��","��","��","��"};
		System.out.println(week[now.getDay()]+"����");
		System.out.println(now.getHours()+"��");
		System.out.println(now.getMinutes()+"��");
		System.out.println(now.getSeconds()+"��");
		
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd�� E");
		System.out.println(sdf.format(now));
	}
}