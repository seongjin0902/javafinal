package Domain.Common.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoImpl;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.Auth.Session;

public class MemberServiceImpl implements MemberService {

	public Map<String, Object> sessionMap;

	private MemberDao dao;

	private static MemberServiceImpl instance;

	public static MemberServiceImpl getInstance() {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		sessionMap = new HashMap();
	}

//	회원 가입하기
	@Override
	public boolean Join(MemberDto dto) throws Exception {
		int result = dao.insert(dto);
		if (result > 0)
			return true;
		return false;
	}

//	회원 조회(전체) - 관리자
	@Override
	public List<MemberDto> memberSearch(String role) throws Exception {
		if (role.equals("MASTER"))
			return dao.select("id", "pw");
		return null;
	}

//	회원 삭제하기
	@Override
	public boolean memberDelete(String id, String role) throws Exception {
		Session session = (Session) sessionMap.get(role);
		if (role == "MASTER" || session.getId().equals(id)) {
			int result = dao.delete(id);
			if (result > 0)
				return true;
		}
		return false;

	}

//	로그인
	@Override
	public Map<String, Object> login(String id, String pw) throws Exception {
//		1. id/pw 체크 -> Dao 전달받은 id와 일치하는 정보를 가져와서 pw일치 확인
		MemberDto dto = (MemberDto) dao.select(id, pw);
		if (dto == null) {
			System.out.println("[ERROR");
			return null;
		}

		if (!pw.equals(dto.getPw())) {
			System.out.println("[ERROR]");
			return null;
		}

//		2. 해당 사용자에 대한 정보를(Session)을 MemberService에 저장
		String role = UUID.randomUUID().toString();
		Session session = new Session(dto.getId(), dto.getPw(), dto.getRole());
		sessionMap.put(role, session);
//		3. 세션에 대한 정보를 클라이언트가 접근할 수 있도록 하는 세션 구별 id(Session Cookie)전달
		Map<String, Object> result = new HashMap();
		result.put("id", id);
		result.put("pw", pw);
		result.put("role", role);
		return result;
	}

//	로그아웃
	@Override
	public Boolean logout(String id, String pw, String role) {

		Session session = (Session) sessionMap.get(role);
		if (id == null || pw == null) {
			System.out.println("[ERROR");
			return false;
		}
		sessionMap.remove(role);
		return null;

	}

//	역할 반환 함수(회원인지 관리자인지)
	@Override
	public String getRole(String role) {
		Session session = (Session) sessionMap.get(role);
		if (session.equals("MASTER")) {
			return session.getRole();
		}

		return null;
	}

}