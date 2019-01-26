# webtoon-vote-server

webtoon-vote-server

## How to install

### 1. Clone this repository to local

```
$ git clone https://github.com/NAVER-CAMPUS-HACKDAY/webtoon-vote/tree/master/webtoonvote
```

### 2. Create  application.properties  `application.properties`

You must create `application.properties` file in `src/main/resources` directory according to this guide 

```
/* 
  src/main/resources/application.properties 
*/

spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR SCHEMA?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true
spring.datasource.username=
spring.datasource.password=
mybatis.type-aliases-package=com.webtoonvote.dto
```

Never upload the file to any Github repository including webtoon-vote

Basically `application.properties` is already registered in `.gitignore`.

### 3. Install  lombok  `lombok.jar`

```
https://projectlombok.org/download.html
```



## Skill Stacks

- Spring Boot
- MySql
- Mybatis