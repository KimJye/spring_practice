package persistance;

import Domain.reply;

import java.util.List;

// 먼저 인터페이스 설정
public interface replyDaoIn {

    // 댓글 데이터 조회
    List<reply> read(int bno);

    // 입력
    int insert(reply r);

    // 삭제
    int delete(int rno);

}
