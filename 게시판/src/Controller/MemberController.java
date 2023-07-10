package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceImpl;

public class MemberController implements SubController{

	private MemberService service;

	public MemberController() {
		service = MemberServiceImpl.getInstance();
	}

	// [CRUD]
	// 1 search 2 join 3 Delete 4 login 5 logout

	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {

		if (serviceNo == 1) { // search
			// 값 추출
			String role = (String) param.get("role");
			// 값 검증X
			// 서비스 실행
			List<MemberDto> list = null;
			try {
				list = service.memberSearch(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view로 전달
			System.out.println("Member_Select Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", list);
			return result;
		} else if (serviceNo == 2) { // join
			// 값 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");

			// 값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 서비스 실행
			MemberDto dto = null;
			System.out.println("Dto : " + dto);
			Boolean rValue = false;
			try {
				rValue = service.Join(new MemberDto("id", "pw", "role"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view로 전달
			System.out.println("Member_Insert Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 3) { // delete
			// 값 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			// 값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 서비스 실행
			Boolean rValue = false;
			try {
				rValue = service.memberDelete(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view로 전달
			System.out.println("Member_Delete Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		} else if (serviceNo == 4) { // login
			// 값 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			// 값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 서비스 실행
			Map<String, Object> result = new HashMap();
			String role = null;
			try {
				result = service.login(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view로 전달
			return result;
		} else if (serviceNo == 5) { // logout
			// 값 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String role = (String) param.get("role");
			// 값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 서비스 실행
			Boolean rValue = false;
			try {
				rValue = service.logout(id, pw, role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// view로 전달
			System.out.println("Member_Logout Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}

		return null;
	}
}