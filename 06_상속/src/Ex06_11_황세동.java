abstract class Employee2{
	private String empno;
	private String name;
	private int pay;
	
	Employee2(String empno ,String name ,int pay){
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}
	
	String getEmpno() {
		return empno;
	}
	
	String getName() {
		return name;
	}
	
	int getPay() {
		return pay;
	}
	
	abstract double getMonthPay();
}

class FullTime extends Employee2{
	private int bonus;
	FullTime(String empno ,String name ,int pay,int bonus){
		super(empno,name,pay);
		this.bonus = bonus;
	}
	
	double getMonthPay() {
		return ((double)super.getPay()/12)+((double)bonus/12);
	}
	
	int getBonus() {
		return bonus;
	}
}

class Contract extends Employee2{
	private int hireYear;
	Contract(String empno ,String name ,int pay,int hireYear){
		super(empno,name,pay);
		this.hireYear = hireYear;
		
	}
	double getMonthPay() {
		return (double)super.getPay()/12*hireYear;
	}
	int getHireYear() {
		return hireYear;
	}
}

class PartTime extends Employee2{
	private int workDay;
	
	PartTime(String empno ,String name ,int pay,int workDay){
		super(empno,name,pay);
		this.workDay = workDay;
		
	}
	double getMonthPay() {
		return super.getPay()*workDay;
	}
	int getWorkDay() {
		return workDay;
	}
}

public class Ex06_11_Ȳ���� {
	public static void main(String[] args) {
		// 3���� ���
		// getMonthPay�� �߻�޼��带 ��� - �޿� ���� ��� �޼���
		FullTime f = new FullTime("f01","����",3000,50);
		Contract c = new Contract("c02","����",2000,3);
		PartTime p = new PartTime("p03","����",7000,25);
		//���� �ɹ� ���� ���
		System.out.printf("FullTime : %s ,%s ,%d ,%d \n",f.getEmpno(),f.getName(),f.getPay(),f.getBonus());
		System.out.printf("Contract : %s ,%s ,%d ,%d \n",c.getEmpno(),c.getName(),c.getPay(),c.getHireYear());
		System.out.printf("PartTime : %s ,%s ,%d ,%d \n",p.getEmpno(),p.getName(),p.getPay(),p.getWorkDay());
		
		System.out.println();
		
		//���
		System.out.printf("FullTime �� �޿� %.2f \n",f.getMonthPay());
		System.out.printf("Contract �� �޿� %.2f \n",c.getMonthPay());
		System.out.printf("PartTime �� �޿� %.2f \n",p.getMonthPay());
		
		//���� ��ü 3�� �迭�� �����
		Employee2[] em = {	new FullTime("f01","����",3000,50),
							new Contract("c02","����",2000,3),
							new PartTime("p03","����",7000,25)};
		
		System.out.println();
		
		for(int i=0;i<em.length;i++) {
			System.out.print(em[i].getEmpno()+", "+em[i].getName()+", "+em[i].getPay()+", ");
			if(em[i] instanceof FullTime) {
				FullTime f0 = (FullTime)em[i];
				System.out.printf("%d\n",f0.getBonus());
			}else if(em[i] instanceof Contract) {
				Contract c0 = (Contract)em[i];
				System.out.printf("%d\n",c0.getHireYear());
			}else if(em[i] instanceof PartTime) {
				PartTime p0 = (PartTime)em[i];
				System.out.printf("%d\n",p0.getWorkDay());
			}
		}
		
		System.out.println();
		
		//�迭�� �ѹ� �� ���
		for(int i=0;i<em.length;i++) {
			System.out.printf("%s�� �޿� %.2f \n",em[i].getName(),em[i].getMonthPay());
		}
	}
}