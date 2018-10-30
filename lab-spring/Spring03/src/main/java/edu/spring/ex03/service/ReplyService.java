package edu.spring.ex03.service;

import java.util.List;

import edu.spring.ex03.domain.Reply;

public interface ReplyService {
	
	List<Reply> select();
	List<Reply> select(int bno);
	int insert(Reply r);
	int update(Reply r);
	int delete(int rno);

}





