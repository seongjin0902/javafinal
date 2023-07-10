package Domain.Common.Dto;

public class MemberDto {
	private String id;
	private String pw;
	private String role;

//	기본 생성자
	public MemberDto() {
	}

//	모든 인자를 받는 생성자
	public MemberDto(String id, String pw, String role) {
		this.id = id;
		this.pw = pw;
		this.role = role;
	}

// 	role인자를 뺀 생성자
	public MemberDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

//	toString 재정의
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", role=" + role + "]";
	}

//	getter and setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}