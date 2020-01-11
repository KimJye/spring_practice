package com.kimjye.springbootjpa.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByName(String name);
}
