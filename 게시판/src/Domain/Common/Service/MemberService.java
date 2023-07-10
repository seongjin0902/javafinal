package Domain.Common.Service;

import java.util.List;
import java.util.Map;

import Domain.Common.Dto.MemberDto;

public interface MemberService {

	//	회원 가입하기
	boolean Join(MemberDto dto) throws Exception;

	//	회원 조회(전체) - 관리자
	List<MemberDto> memberSearch(String role) throws Exception;

	//	회원 삭제하기
	boolean memberDelete(String id, String role) throws Exception;

	//	로그인
	Map<String, Object> login(String id, String pw) throws Exception;

	//	로그아웃
	Boolean logout(String id, String pw, String role);

	//	역할 반환 함수(회원인지 관리자인지)
	String getRole(String role);

}