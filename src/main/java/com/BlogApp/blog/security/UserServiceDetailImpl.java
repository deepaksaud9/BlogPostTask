package com.BlogApp.blog.security;

import com.BlogApp.blog.userinfo.Repository.UserInfoRepo;
import com.BlogApp.blog.userinfo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


    UserInfo user=userInfoRepo.findByEmail(email)
            .orElseThrow(()->new UsernameNotFoundException("User not found"));

        return UserPrinciple.build(user);
    }
}
