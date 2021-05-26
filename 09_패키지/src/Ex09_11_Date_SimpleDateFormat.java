import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_11_Date_SimpleDateFormat {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now.getYear()+1900+"년");
		System.out.println(now.getMonth()+1+"월");
		System.out.println(now.getDate()+"일");
		
		String[] week = {"일","월","화","수","목","금","토"};
		System.out.println(week[now.getDay()]+"요일");
		System.out.println(now.getHours()+"시");
		System.out.println(now.getMinutes()+"분");
		System.out.println(now.getSeconds()+"초");
		
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd일 E");
		System.out.println(sdf.format(now));
	}
}