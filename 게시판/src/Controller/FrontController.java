package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	
	private Map<String, SubController> map = new HashMap();
	
	private void init() {
		map.put("/Board", new BoardController());
		map.put("/Member", new MemberController());
	}
	
	public FrontController() {
		init();
	}
	
	public Map<String, Object> execute(String request, int ServiceNo, Map<String, Object> param){
		SubController controller = map.get(request);
		
		Map<String,Object> result = new HashMap();
		result = controller.execute(ServiceNo, param);
		return result;
	}
	
	

}