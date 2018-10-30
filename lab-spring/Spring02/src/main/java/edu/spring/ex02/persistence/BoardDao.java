package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.Board;
import edu.spring.ex02.pageutil.PaginationCriteria;

// CRUD(Create, Read, Update, Delete)
public interface BoardDao {
	
	// 전체 검색 기능
	List<Board> read();
	
	// 글번호 검색 기능
	Board read(int bno);
	
	// 작성자 아이디 검색 기능
	List<Board> read(String userid);
	
	// 제목 + 내용 검색 기능
	List<Board> read(String title, String content);
	
	// 새 글 작성 기능
	int create(Board b);
	
	// 작성된 글 수정(수정 컬럼: title & content & regdate, 데이터: bno)
	int update(Board b);
	
	// 글 삭제
	int delete(int bno);
	
	// 검색
	List<Board> search(int type, String keyword);

	// 전체 게시글 갯수를 리턴하는 메소드
	int getTotalCount();
	
	// 한 페이지에 보여줄 게시글 리스트만 리턴하는 메소드
	List<Board> read(PaginationCriteria c);
	
} // end interface BoardDao







