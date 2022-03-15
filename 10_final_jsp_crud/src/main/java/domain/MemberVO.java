package domain;

public class MemberVO {
	private String email;
	private String pwd;
	private String nickName;
	private String regAt;
	private String lastLogin;
	private int grade;
	// spring에서는 regAt 등 공동된 속성은 추상클래스에 넣어놓고 extends로 받는다.
	
	public MemberVO() {}
	
	// 계정 생성
	public MemberVO(String email, String pwd, String nickName) {
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
	}
	
	// 계정 로그인
	public MemberVO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	// 계정 업데이트
	public MemberVO(String email, String pwd, String nickName, int grade) {
		this(email, pwd, nickName);
		this.grade = grade;
	}

	// 리스트 
	public MemberVO(String email, String nickName, String regAt, int grade, String lastLogin) {
		this.email = email;
		this.nickName = nickName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
	}
	
	// 디테일
	public MemberVO(String email, String pwd, String nickName, String regAt, String lastLogin, int grade) {
		this.email = email;
		this.pwd = pwd;
		this.nickName = nickName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
	}
	

	public final String getEmail() {
		return email;
	}


	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPwd() {
		return pwd;
	}

	public final void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public final String getNickName() {
		return nickName;
	}

	public final void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public final String getRegAt() {
		return regAt;
	}

	public final void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public final String getLastLogin() {
		return lastLogin;
	}

	public final void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public final int getGrade() {
		return grade;
	}

	public final void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwd=" + pwd + ", nickName=" + nickName + ", regAt=" + regAt
				+ ", lastLogin=" + lastLogin + ", grade=" + grade + "]";
	}
	
	
}
