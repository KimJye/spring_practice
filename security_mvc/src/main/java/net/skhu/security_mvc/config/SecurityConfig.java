package net.skhu.security_mvc.config;

import net.skhu.security_mvc.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
// Spring Security 설정을 위한 Java Config 클래스.
// WebSecurityConfigurerAdapter guide :
// https://docs.spring.io/spring-security/site/docs/4.2.8.RELEASE/apidocs/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/res/**");
    }
    /*
          리소스 파일 무시하는 메소드.
          /res/** 패턴의 URL은 보안 검사를 하지 말고 무시하라는 설정이다.
          여기에는 *.css *.js *.png 등등 리소스 파일이 들어있다.
          웹브라우저자 이 파일들을 요청할 때는 보안 검사를 할 필요가 없다.
     */

    // 권한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 권한 설정 시작
        http.authorizeRequests()
                .antMatchers("/admin/**").access("ROLE_ADMIN")
                .antMatchers("/professor/**").access("ROLE_PROFESSOR")
                .antMatchers("/guest/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/**").authenticated();
        /*
           .antMatchers () : 주어진 패턴( 파라미터 )의 URL은
           .access () : "ROLE_ADMIN" 권한을 소요한 사용자만 요청할 수 있다는 설정.
           로그인된 현재 사용자가 ROLE_ADMIN 권한을 소유하고 있지 않다면
           /admin/** 패턴의 URL 요청은 spring security 엔진에 의해서 거부된다.
           ----------------------------------------------------------------------
           .antMatchers() : /guest/** 패턴의 URL은
           .permitAll() : 모든 사용자에게 허용된다는 설정이다.
            로그인하지 않은 사용자에게도 허용된다.
           ----------------------------------------------------------------------
           .antMatchers() : /** 패턴의 URL은
           .authenticated() : 로그인된 사용자에게만 허용된다는 설정이다.
         */

        // csrf
        // CSRF 공격 검사를 하지 않겠다는 설정이다.
        http.csrf().disable();

        // 로그인 페이지 설정 시작
        http.formLogin()
                .loginPage("/guest/login") // 로그인 페이지 URL 설정. 이 URL의 액션 메소드와 뷰 파일을 구현해야 한다.
                .loginProcessingUrl("/guest/login_processing")
                /*
                로그인 페이지에서 '로그인' 버튼(submit button)을 눌렀을 때 요청할 URL 설정.
                이 URL이 요청되면 (즉 '로그인' 버튼이 눌려지면),
                spring security 엔진이 MyAuthenficationProvider의 authenticate 메소드를 호출하여
                로그인 검사를 수행한다.
                즉 이 URL이 요청되면, 로그인 절차는 spring security 엔진에 의해서 자동으로 진행된다.
                 */
                .failureUrl("/guest/login?error") //로그인이 실패했을 때 (로그인 아이디, 비밀번호가 일치하지 않았을 때) 넘어갈(redirect) URL 설정
                .defaultSuccessUrl("/user/index", true)//로그인이 성공했을 때. 넘어갈(redirect) URL 설정
                // 로그인 페이지 (뷰 파일)에서, 로그인 아이디 input 태그의 name 값과, 비밀번호 input 태그의 name 값 설정
                .usernameParameter("loginId")
                .passwordParameter("passwd");

        // 로그아웃 설정 시작
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing"))
                /*
                로그아웃 버튼이나 링크를 눌렀을 때 요청할 URL 설정.
                이 URL이 요청되면, 로그아웃 절차는 spring security 엔진에 의해서 자동으로 진행된다
                 */
                .logoutSuccessUrl("/guest/login") // 로그아웃된 후 넘어갈(redirect) URL 설정
                .invalidateHttpSession(true); //로그아웃할 때, 세션(session)에 들어있는 데이터를 전부 지우라는 설정

        http.authenticationProvider(myAuthenticationProvider);
    }
}
