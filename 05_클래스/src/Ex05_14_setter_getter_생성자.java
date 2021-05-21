class Member{
	private String id;
	private String passwd;
	
	/*
	 * 생성자(Constructor)
	 * 클래스와 이름이 똑같은 메서드
	 * 리턴값 없음
	 */
	void setId(String id) {
		this.id = id;
	}
	void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	String getId() {
		return id;
	}
	String getPasswd() {
		return passwd;
	}
}
public class Ex05_14_setter_getter_생성자 {
	public static void main(String[] args) {
		Member m = new Member();
		m.setId("아이디");
		m.setPasswd("비밀번호");
		System.out.println(m.getId());
		System.out.println(m.getPasswd());
	}
}