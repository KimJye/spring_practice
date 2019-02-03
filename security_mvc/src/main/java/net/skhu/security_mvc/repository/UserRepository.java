package net.skhu.security_mvc.repository;

import net.skhu.security_mvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    //User 테이블에서 logindId 필드로 레코드를 조회하는 메소드
    // DB에 loginId로 조회한 레코드가 2개 이상이면,
    //findOneByLoginId(loginId) 메소드에서 에러가 발생
    User findOneByLoginId(String loginId);
}
