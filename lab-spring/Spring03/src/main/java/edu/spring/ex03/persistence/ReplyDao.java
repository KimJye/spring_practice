package edu.spring.ex03.persistence;

import java.util.List;

import edu.spring.ex03.domain.Reply;

public interface ReplyDao {
	
	List<Reply> read();
	List<Reply> read(int bno);
	int create(Reply r);
	int update(Reply r);
	int delete(int rno);
	Integer getBno(int rno);
	
} // end interface ReplyDao






