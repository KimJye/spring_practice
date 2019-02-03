package net.skhu.security_mvc.service;

import net.skhu.security_mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// MyAuthenticationProvider 클래스는 사용자가 입력한 로그인 아이디와 비밀번호를 검사할 때 사용되는 클래스이다.
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired UserService userService;

    // AuthenticationProvider 인터페이스 구현하니까 authentication 메서드를 Override한다.
    // Attempts to authenticate the passed Authentication object, returning a fully populated Authentication object (including granted authorities) if successful.
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String loginId = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 간단하게는 이 메소드에서 바로 비교하여 올바른 객체를 리턴하겠지만 커스터마이징.
        return authentication(loginId,password);
    }

    // 커스터마이징한 비교 메소드.
    // 사용자가 입력한 로그인 아이디와 비밀번호를 검사해야 할 때,
    // spring security 엔진에 의해서 이 클래스의 authenticate 메소드가 자동으로 호출된다.
    // 사용자가 입력한 로그인 아이디와 비밀번호가 이 메소드의 파라미터로 전달된다
    public Authentication authentication(String loginId, String password) throws  AuthenticationException{
        User user = userService.login(loginId,password);
        if(user==null) return null;

        /*
            GrantedAuthority는 현재 사용자(principal)가 가지고 있는 권한.
            UserDetailsService에 의해 보통 로드된다.
            사용자가 가지고 있는 권한인 Autorities들을 가져와서 특정 자원에 권한이 있는지를 체크하여
            접근을 허용할지 말지를 체크하는데 쓰인다.
         */
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        String role="";
        switch (user.getUserType()){
            case "관리자" : role= "ROLE_ADMIN"; break;
            case "교수" : role = "ROLE_PROFESSOR"; break;
            case "학생" : role = "ROLE_STUDENT"; break;
        }

        grantedAuthorities.add(new SimpleGrantedAuthority(role));

        // 여기서 UsernamePasswordAuthenticationToken을 생성해서 바로 리턴해도 괜찮다.
        return new MyAuthentication(loginId, password, grantedAuthorities, user);
    }

    // AuthenticationProvider 인터페이스 구현하니까 supports 메서드를 Override한다.
    // Returns true if this AuthenticationProvider supports the indicated Authentication object.
    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public class MyAuthentication extends UsernamePasswordAuthenticationToken{
        private static final long serialVersionUID = 1L;
        User user;

        public MyAuthentication(String loginId, String password,
                               List<GrantedAuthority> grantedAuthorities, User user){
            super(loginId, password, grantedAuthorities);
            this.user = user;
        }

        public User getUser(){
            return user;
        }

        public void setUser(User user){
            this.user = user;
        }

    }

    /*
    private static final long serialVersionUID = 1L;
    직렬화란?
    JVM 힙 영역에 존재하는 객체를 한 줄로 늘어선 바이트의 형태로 만드는 것을 객체의 직렬화라고 하고, 객체의 형태로 복원하는 작업을 역직렬화라고 한다.
    직렬화 복원은 serialVersionUID = 1L 이 숫자를 사용하여 로드 된 클래스가 직렬화 된 객체와 정확히 일치하는지 확인한다.
    일치하는 항목이 없으면 an InvalidClassException이 throw된다.
     */
}

