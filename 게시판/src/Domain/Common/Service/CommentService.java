package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dao.BoardDao;
import Domain.Common.Dao.CommentDao;
import Domain.Common.Dto.CommentDto;

public class CommentService {

	private CommentDao dao;
	
	private static CommentService instance;
	public static CommentService getInstance() {
		if(instance == null) instance = new CommentService();
		return instance;
	}
	private MemberService memberService;
	
	
	private CommentService() {
		dao = CommentDao.getInstance();
		memberService = MemberService.getInstance();
	}
//	��� ��ȸ�ϱ� - ��ü
	public List<CommentDto> Commentselecat(CommentDto dto) throws Exception{
		return null;
	}
	
//	��� ����ϱ� - ȸ��
	public boolean Commentadd(CommentDto dto, String role) throws Exception{
		return false;

	}
	
//	��� �����ϱ�
	public boolean Commentupdate(CommentDto dto, String role) throws Exception{
		return false;

	}
	
//	��� �����ϱ�
	public boolean Commentdelete(String id, String pw, String role) throws Exception{
		return false;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}