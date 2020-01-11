package com.kimjye.springbootjpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println(databaseMetaData.getURL());
            System.out.println(databaseMetaData.getUserName());
            System.out.println(databaseMetaData.getDriverName());
        }
    }

    @Test
    public void account() {
        Account account = new Account();
        account.setName("kimjye");
        account.setPassword("1234");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

        Account existingAccount = accountRepository.findByName(newAccount.getName());
        assertThat(existingAccount).isNotNull();

        Account nonExistingAccount = accountRepository.findByName("ruby");
        assertThat(nonExistingAccount).isNull();
    }
}