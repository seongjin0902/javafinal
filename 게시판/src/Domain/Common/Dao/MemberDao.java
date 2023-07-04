package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.MemberDto;

public class MemberDao {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private static MemberDao instance;
	public static MemberDao getInstance() {
		if(instance==null)
			instance = new MemberDao();
		return instance;
	}
	
	public MemberDao(){
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
//	회원 id/pw 수정
	public int update(MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("update tbl_member set id=?,pw=?");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		return pstmt.executeUpdate();
	}
	
//	회원 id/pw 저장
	public int insert(MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,'MEMBER')");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		return pstmt.executeUpdate();
	}
// 	회원 id/pw 조회
	public List<MemberDto> select() throws Exception{
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_member");
		rs = pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				list.add(dto);
			}
		}
		return list;
	}
//	회원 id/pw 삭제
	public int delete(MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("delete from tbl_member where id = ?");
		pstmt.setString(1,dto.getId());
		
		return pstmt.executeUpdate();
	}
}
