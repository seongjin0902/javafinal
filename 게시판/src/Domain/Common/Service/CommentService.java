package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dto.CommentDto;

public interface CommentService {

	//	댓글 조회하기 - 전체
	List<CommentDto> Commentselecat(CommentDto dto) throws Exception;

	//	댓글 등록하기 - 회원
	boolean Commentadd(CommentDto dto, String role) throws Exception;

	//	댓글 수정하기
	boolean Commentupdate(CommentDto dto, String role) throws Exception;

	//	댓글 삭제하기
	boolean Commentdelete(String id, String pw, String role) throws Exception;

}