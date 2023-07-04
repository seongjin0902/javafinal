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
//	댓글 조회하기 - 전체
	public List<CommentDto> Commentselecat(CommentDto dto) throws Exception{
		return null;
	}
	
//	댓글 등록하기 - 회원
	public boolean Commentadd(CommentDto dto, String role) throws Exception{
		return false;

	}
	
//	댓글 수정하기
	public boolean Commentupdate(CommentDto dto, String role) throws Exception{
		return false;

	}
	
//	댓글 삭제하기
	public boolean Commentdelete(String id, String pw, String role) throws Exception{
		return false;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}