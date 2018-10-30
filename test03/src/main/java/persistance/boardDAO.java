package persistance;

import Domain.board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pageutil.PaginationCriteria;

import java.util.List;

@Repository
public class boardDAO implements boardDaoIn {

  private static final String NAMESPACE = "boardmapper";

  @Autowired
    private SqlSession session;

    public int insert(board b) {
        return session.insert(NAMESPACE+".insertboard", b);
    }

    public int delete(int bno){return session.delete(NAMESPACE+".deleteboard", bno); }



  public List<board> selectList(PaginationCriteria c) {
    return session.selectList(NAMESPACE+".selectPage", c);
  }

  public int getTotalCount() {
    return session.selectOne(NAMESPACE+".totalCount");
  }

  public board selectByBno(int bno) {
    return session.selectOne(NAMESPACE + ".selectByBno", bno);
  }

}
