class Robot{
	
}
class DanceRobot extends Robot{
	void dancd() {
		System.out.println("��");
	}
}
class SingRobot extends Robot{
	void sing() {
		System.out.println("�뷡");
	}
	
}
class DrawRobot extends Robot{
	void draw() {
		System.out.println("�׸�");
	}
	
}
public class Ex06_09_������ {
	public static void main(String[] args) {
		DanceRobot dance = new DanceRobot();
		SingRobot sing = new SingRobot();
		DrawRobot draw = new DrawRobot();
		
		dance.dancd();
		sing.sing();
		draw.draw();
		
		System.out.println();
		
		Robot dance2 = new DanceRobot();
		Robot sing2 = new SingRobot();
		Robot draw2 = new DrawRobot();
		
		Robot[] arr= {dance2,sing2,draw2};
		
		for(int i=0;i<arr.length;i++) {
			action(arr[i]);
		}
	}
	static void action(Robot robot) {
		if(robot instanceof DanceRobot) {
			DanceRobot da=(DanceRobot)robot;
			da.dancd();
		} else if(robot instanceof SingRobot) {
			SingRobot si = (SingRobot)robot;
			si.sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot dr = (DrawRobot)robot;
			dr.draw();
		}
	}
}