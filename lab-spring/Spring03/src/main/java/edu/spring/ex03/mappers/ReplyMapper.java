package edu.spring.ex03.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.ex03.domain.Reply;

public interface ReplyMapper {
	String SQL_INSERT =
			"INSERT INTO test_reply (bno, rtext, replier, regdate)"
			+ " VALUES (#{bno}, #{rtext}, #{replier}, sysdate)";
	String SQL_UPDATE =
			"UPDATE test_reply"
			+ " SET rtext = #{rtext}, regdate = sysdate"
			+ " WHERE rno = #{rno}";
	String SQL_SELECT_BY_BNO = 
			"SELECT * FROM test_reply"
			+ " WHERE bno = #{bno}"
			+ " ORDER BY rno DESC";
	String SQL_GET_BNO =
			"SELECT bno FROM test_reply"
			+ " WHERE rno = #{rno}";
	
	@Select(SQL_GET_BNO)
	Integer getBnoByRno(int rno);
	
	@Select(SQL_SELECT_BY_BNO)
	List<Reply> read(int bno);
	// 어노테이션과 인터페이스를 사용할 때 
	// xml 파일의 id와 겹치는 이름의 메소드를 사용할 수는 없다!
	
	@Insert(SQL_INSERT)
	int insert(Reply r);
	
	@Update(SQL_UPDATE)
	int update(Reply r);
	
	// Mapper 인터페이스 메소드의 이름을 
	// Mapper xml 파일의 SQL 문의 id와 동일하게만 만들어 주면
	// xml 파일에 정의된 SQL문을 사용하는 메소드가 됨
	// edu.spring.ex03.mappers.ReplyMapper.delete
	int delete(int rno);
	
} // end interface ReplyMapper





