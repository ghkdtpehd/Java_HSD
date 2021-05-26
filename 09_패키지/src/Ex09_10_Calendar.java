import java.util.Calendar;

public class Ex09_10_Calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		
		System.out.println(cal.get(Calendar.YEAR)+"��");
		
		System.out.println(cal.get(Calendar.MONTH)+1+"��");
		
		System.out.println(cal.get(Calendar.DATE)+"��");
		
		String[] week = {"��","��","ȭ","��","��","��","��"};
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)+"����");
		
		System.out.println(week[cal.get(Calendar.DAY_OF_WEEK)-1]+"����");
		
		int ampm = cal.get(Calendar.AM_PM);
		if(ampm == 0) {
			System.out.println("AM");
		}else {
			System.out.println("PM");
		}
		System.out.println(cal.get(Calendar.HOUR)+"��"+cal.get(Calendar.MINUTE)+"��"+cal.get(Calendar.SECOND)+"��");
	}
}