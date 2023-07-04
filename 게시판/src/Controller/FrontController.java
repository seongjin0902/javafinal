package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	
	Map<String, Object> map = new HashMap();
	
	void init() {
		map.put("/Board", new BoardController());
		map.put("/Member", new MemberController());
	}
	
	public FrontController() {
		init();
	}
	
	public Map<String, Object> execute(String request, int ServiceNo, Map<String, Object> param){
		Object controller = map.get(request);
		Map<String, Object> result = new HashMap();
		if(controller instanceof BoardController)
		{
			BoardController down = (BoardController)controller;
			result = down.execute(ServiceNo, param);
			down.execute(ServiceNo, param);
			System.out.println("BoardController!");
		}
		else if(controller instanceof MemberController)
		{
			MemberController down = (MemberController)controller;
			down.execute(ServiceNo, param);
			System.out.println("MemberController!");
		}
		else
		{
			System.out.println("Request ERROR!");
		}
		return result;
	}
	
	

}