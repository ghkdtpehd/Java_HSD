
public class Student_hsd extends Person_hsd{
	private int java;
	private int jsp;
	
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getJsp() {
		return jsp;
	}
	
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	
	public Student_hsd(String name, int age, int java, int jsp) {
		super(name, age);
		this.java = java;
		this.jsp = jsp;
	}
	
	public String toString() {
		return super.toString()+", "+ java + ", " + jsp;
	}
	
}
