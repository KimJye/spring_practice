package edu.spring.ex03.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImple implements BoardDao {
	private static final String NAMESPACE =
			"edu.spring.ex03.mappers.BoardMapper";
	
	@Autowired SqlSession session;
	
	@Override
	public int updateReplyCnt(int bno, int amount) {
		Map<String, Integer> args = new HashMap<>();
		args.put("bno", bno);
		args.put("amount", amount);
		
		return session.update(NAMESPACE + ".updateReplyCnt", args);
	}

}



