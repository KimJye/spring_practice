package net.skhu.form1.repository;

import net.skhu.form1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserid(String userid);
}
