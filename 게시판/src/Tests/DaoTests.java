package Tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import Domain.Common.Dao.BoardDao;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Dto.MemberDto;

class DaoTests {

	@Test
	void Test1_MemberDaoTest() throws Exception{
		MemberDao dao = MemberDao.getInstance(); 
		assertNotNull(dao);
		
		dao.insert(new MemberDto("오구","1234", null));
	}
	@Test
	void Test1_BoardDaoTest() throws Exception{				// insert
		BoardDao dao = BoardDao.getInstance(); 
		assertNotNull(dao);
		
		dao.insert(new BoardDto(0, "오구","1234","dfasdfsaf", null, 0), null);
	}
	@Test
	void Test1_BoardDaoTest2() throws Exception{			// update
		BoardDao dao = BoardDao.getInstance(); 
		assertNotNull(dao);
		
		dao.update(new BoardDto(0, "오구","1235", "오구구구구구구", null, 0));
	}
	@Test
	void Test1_BoardDaoTest3() throws Exception{			// delete
		BoardDao dao = BoardDao.getInstance(); 
		assertNotNull(dao);
		
		dao.delete(new BoardDto(0, "오구","1235", "sadfadfsafdasdfafdsadf", null, 0));
	}
}