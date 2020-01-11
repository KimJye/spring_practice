package com.kimjye.springbootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // try resource..java8... finally블럭 필요없음..
        try(Connection connection = dataSource.getConnection()){
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql="CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }

        // spring-jdbc가 제공하는 jdbcTemplate를 사용하면 코드를 간결하게 사용할 수 있고 try-catch같은 리소스 반납처리도
        // 잘 되어있다. 또한 예외를 던질 때 가독성이 높은(에러를 계층구조로 만들었다.) 에러메시지를 볼 수 있다.
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'kimjye')");
    }
}
