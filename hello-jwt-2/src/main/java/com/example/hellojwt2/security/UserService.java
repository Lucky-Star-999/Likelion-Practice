package com.example.hellojwt2.security;

import com.example.hellojwt2.entity.UserInfo;
import com.example.hellojwt2.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kiểm tra xem user có tồn tại trong database không?
        UserInfo userInfo = userInfoRepository.findByEmail(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(userInfo);
    }

    public UserDetails loadUserById(String id) throws UsernameNotFoundException {
        // Kiểm tra xem user có tồn tại trong database không?
        Optional<UserInfo> user = userInfoRepository.findById(id);
        if (user.isPresent() == false) {
            throw new UsernameNotFoundException("Long " + id);
        }
        return new CustomUserDetails(user.get());
    }
}
