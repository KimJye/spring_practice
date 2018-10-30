package persistance;

import Domain.reply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class replyDAO implements replyDaoIn {

    private static final String NAMESPACE = "replymapper";

    @Autowired private SqlSession session;

    // json 라이브러리를 통해 웹에 표기할 reply의 list를 읽어오는 메소드
    // 방금 mapper에서 설정한 내용을 그대로 이용
    public List<reply> read(int bno) {
        return session.selectList(NAMESPACE+".selectByBno", bno);
    }

    // 댓글 입력
    public int insert(reply r) {
        return session.insert(NAMESPACE+".insertReply", r);
    }

    // 댓글 삭제
    public int delete(int rno) {
        return session.delete(NAMESPACE+".deleteReply", rno);
    }
}