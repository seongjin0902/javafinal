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
	public int insert(BoardDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_contents values (?,?,?,?,now())");
		pstmt.setInt(1, dto.getNumber());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getTitle());
		pstmt.setString(4, dto.getContents());
		pstmt.setString(5, dto.getNowdate());
		
		return pstmt.executeUpdate();
	}
//	전체글 조회
	public List<BoardDto> select_all() throws Exception{
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
//	id 나 title로 글 조회
	public List<BoardDto> select_id(String id) throws Exception{
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
	public List<BoardDto> select_title(String title) throws Exception{
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
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContents());
		
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