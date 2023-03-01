package com.ss.Jamong.user.service;


import com.ss.Jamong.user.entity.User;
import com.ss.Jamong.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
//        user.setEnabled(true);
        return userRepository.save(user);
    }

    //id 중복 검사
    public String idCheck(String username) {
        Optional<User> optionalMemberEntity = userRepository.findByUsername(username);
        if (optionalMemberEntity.isEmpty()){
            return "ok";
        }else{
            return "no";
        }
    }

    //닉네임 중복 검사
//    public HashMap<String, Object> nicknameOverlap(String nickname) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("result", userRepository.existsByNickname(nickname));
//        return map;
//    }
}
