package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BoardDto;

public class BoardDao {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//싱글톤 패턴
		private static BoardDao instance; 
		public static BoardDao getInstance() {
			if(instance==null)
				instance=new BoardDao();
			return instance;
		}
	
	private BoardDao() {
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/게시판";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//		CURD
//	글 작성
	public int insert(BoardDto dto, String role) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_board values (null,?,?,?,now(),null)");
		
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3, dto.getContents());
		
		return pstmt.executeUpdate();
	}
//	전체글 조회
	public List<BoardDto> select() throws Exception{
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_contents");
		rs=pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new BoardDto();
				dto.setNumber(rs.getInt("number"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setNowdate(rs.getString("date"));
				dto.setHits(rs.getInt("hits"));
				list.add(dto);
			}
		}
		return list;
	}
	
	//글 하나 조회(number로 조회)
	public BoardDto select(int number) {
		
		//여기에 DB연결 코드를 입력해야함
		//number로 글 하나를 받아오는 것
		return null;
	}
	
//	id 나 title로 글 조회
	public List<BoardDto> search_id(String id) throws Exception{
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_contents where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs!=null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setNowdate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}
	public List<BoardDto> search_title(String title) throws Exception{
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_contents where title = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs!=null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setNowdate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}
//	내가 쓴 글 조회
	public List<BoardDto> select_mine(String id) throws Exception{
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_contents where id = ?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs!=null) {
			rs.next();
			dto = new BoardDto();
			dto.setNumber(rs.getInt("number"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setNowdate(rs.getString("date"));
			dto.setHits(rs.getInt("hits"));
			rs.close();
		}
		pstmt.close();
		return list;
	}
//	내가 쓴 글 수정
	public int update(BoardDto dto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_contents set title=?,contents=?");
		pstmt.setString(3, dto.getTitle());
		pstmt.setString(4, dto.getContents());
		
		return pstmt.executeUpdate();
	}
//	내가 쓴 글 삭제
	public int delete(BoardDto dto) throws Exception{
		pstmt = conn.prepareStatement("delete from tbl_contents where id = ? and title = ?");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getTitle());
		
		return pstmt.executeUpdate();
	}


	
	
}