class Bank{
	private int money =10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public synchronized void saveMoney(int save) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.money += save;
	}
	
	public void minusMoney(int money) {
		synchronized (this) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.money -= money;
		}
	}
}
class Pack extends Thread{
	public void run() {
		synchronized (Ex11_10_SyncBank.bk) {
			Ex11_10_SyncBank.bk.saveMoney(3000);
		}
		System.out.println("Pack saveMoney 3000 : " + Ex11_10_SyncBank.bk.getMoney());
	}
}
class Kim extends Thread{
	public void run() {
		synchronized (Ex11_10_SyncBank.bk) {
			Ex11_10_SyncBank.bk.saveMoney(500);
			System.out.println("Kim saveMoney 500 : " + Ex11_10_SyncBank.bk.getMoney());
			
			Ex11_10_SyncBank.bk.minusMoney(1000);
			System.out.println("Kim saveMoney 1000 : " + Ex11_10_SyncBank.bk.getMoney());
		}
	}
}
public class Ex11_10_SyncBank {
	
	static Bank bk = new Bank();
	
	public static void main(String[] args) {
		System.out.println("¿ø±Ý : "+bk.getMoney());
		Pack p = new Pack();
		Kim k = new Kim();
		
		p.start();
		k.start();
	}
}