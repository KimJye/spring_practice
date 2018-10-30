package persistance;

import Domain.board;
import pageutil.PaginationCriteria;

import java.util.List;

public interface boardDaoIn {

    int insert(board b);
    int delete(int bno);

    List<board> selectList(PaginationCriteria c);
    int getTotalCount();
    board selectByBno(int bno);

}
