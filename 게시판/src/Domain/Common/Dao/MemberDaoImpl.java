package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.MemberDto;

public class MemberDaoImpl extends ConnectionPool implements MemberDao{

	
	private static MemberDao instance;
	public static MemberDao getInstance() {
		if(instance==null)
			instance = new MemberDaoImpl();
		return instance;
	}
	
	//id 게터
	@Override
	public String getId() {
        return id;
    }
	
	public MemberDaoImpl(){

	}
	//쓸지 안쓸지 모른다. 고민중...
//	회원 id/pw 수정
//	public int update(MemberDto dto) throws Exception{
//		pstmt = conn.prepareStatement("update tbl_member set id=?,pw=?");
	
	//아이디에 따라 비번바꾸는 쿼리문
//		pstmt = conn.prepareStatement("update tbl_member set pw=? where id=?");
//		pstmt.setString(1, dto.getId());
//		pstmt.setString(2, dto.getPw());
//		
//		return pstmt.executeUpdate();
//	}
	
//	회원 id/pw 저장
	@Override
	public int insert(MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,'MEMBER')");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		return pstmt.executeUpdate();
	}
// 	회원 id/pw 조회
	@Override
	public List<MemberDto> select(String id, String pw) throws Exception{
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
	@Override
	public int delete(String id) throws Exception{
		
		pstmt = conn.prepareStatement("delete from tbl_member where id = ?");
		pstmt.setString(1,id);
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
		
	}
}