package net.skhu.security_mvc.service;

import net.skhu.security_mvc.domain.User;
import net.skhu.security_mvc.repository.UserRepository;
import net.skhu.security_mvc.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User login(String loginId, String password){
        User user = userRepository.findOneByLoginId(loginId);
        if(user==null) return null;

        // db에서 pw가 MD5 암호화 되어잇다.
        String pw = EncryptionUtils.encryptMD5(password);
        if(user.getPassword().equals(pw)==false) return null;
        return user;
    }
}
