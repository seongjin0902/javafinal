package Domain.Common.Dto;

public class BoardDto {
	private int number; 		//게시물 번호
	private String id;  		//userid 
	private String title;		//글제목
	private String contents;	//글내용
	private String Nowdate;		//작성날짜
	private int hits;			//조회수
	
//	디폴트 생성자
	public BoardDto() {}
	
//	모든 인자를 받는 생성자
	public BoardDto(int number, String id, String title, String contents, String Nowdate, int hits) {
		this.number = number;
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.Nowdate = Nowdate;
		this.hits = hits;
	}

//	toString 재정의
	@Override
	public String toString() {
		return "ContentsDto [number=" + number + ", id=" + id + ", title=" + title + ", contents=" + contents
				+ ", Nowdate=" + Nowdate + ", hits=" + hits + "]";
	}

//	getter and setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getNowdate() {
		return Nowdate;
	}

	public void setNowdate(String Nowdate) {
		this.Nowdate = Nowdate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
	
}