import java.util.Calendar;

public class Ex09_10_Calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		
		System.out.println(cal.get(Calendar.YEAR)+"년");
		
		System.out.println(cal.get(Calendar.MONTH)+1+"월");
		
		System.out.println(cal.get(Calendar.DATE)+"일");
		
		String[] week = {"일","월","화","수","목","금","토"};
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)+"요일");
		
		System.out.println(week[cal.get(Calendar.DAY_OF_WEEK)-1]+"요일");
		
		int ampm = cal.get(Calendar.AM_PM);
		if(ampm == 0) {
			System.out.println("AM");
		}else {
			System.out.println("PM");
		}
		System.out.println(cal.get(Calendar.HOUR)+"시"+cal.get(Calendar.MINUTE)+"분"+cal.get(Calendar.SECOND)+"초");
	}
}