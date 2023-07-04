package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.CommentDto;

public class CommentDao {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CommentDao(){
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
//	댓글 조회
	public List<CommentDto> select() throws Exception{
		List<CommentDto> list = new ArrayList();
		CommentDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_comment");
		rs = pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new CommentDto();
				dto.setId(rs.getString("id"));
				dto.setComment(rs.getString("comment"));
				dto.setDate(rs.getString("date"));
				list.add(dto);
			}
		}
		return list;
	}
//	댓글 작성 
	public int insert(CommentDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_comment values(?,?,now())");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getComment());
		
		return pstmt.executeUpdate();
	}
//	댓글 수정
	public int update(CommentDto dto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_comment set id=?,comment=?,date=now()");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getComment());
		pstmt.setString(3, dto.getDate());
		
		return pstmt.executeUpdate();
	}
//	댓글 삭제
	public int delete(String id) throws Exception{
		pstmt = conn.prepareStatement("delete from tbl_comment where id=?");
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}
}