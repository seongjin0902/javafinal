package Domain.Common.Dto;

public class MemberDto {
	private String id;
	private String pw;
	
//	기본 생성자
	public MemberDto() {}
	
//	모든 인자를 받는 생성자
	public MemberDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

//	toString 재정의
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + "]";
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
	
}