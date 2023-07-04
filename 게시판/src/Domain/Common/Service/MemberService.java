package Domain.Common.Service;

import java.util.List;
import java.util.Map;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.MemberDto;

public class MemberService {

		public Map<String, Object> sessionMap;
		
		private MemberDao dao;
	
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}
	
	private MemberService() {

	}
	
//	회원 가입하기
	public boolean Join(MemberDto dto) throws Exception{
		return false;
	}
	
//	회원 조회(전체) - 회원
	public List<MemberDto> memberSearch(String role) throws Exception {
		return null;
	}
	
//	회원 삭제하기
	public boolean memberDelete(String id, String role) throws Exception {
		return false;

	}
	
//	로그인
	public Map<String, Object> login(String id, String pw) throws Exception{
		return null;
	}
	
//	로그아웃
	public Boolean logout(String id, String pw) {
		return false;

	}
	

//	역할 반환 함수(회원인지 관리자인지)
	public String getRole(String sid) {
		return null;
	}
	
}