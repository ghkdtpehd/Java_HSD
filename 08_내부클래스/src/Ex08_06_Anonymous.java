class Test3 implements RemoteControl{
	public void turnOn () {
		
	}
	public void turnOff () {
		
	}
}
interface RemoteControl{
	void turnOn();
	void turnOff();
}
public class Ex08_06_Anonymous {

	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			public void turnOn () {
				System.out.println("Tv дт");
			}
			public void turnOff () {
				System.out.println("Tv ╡Ш");
			}
		};
		
		rc.turnOn();
		rc.turnOff();
	}

}
