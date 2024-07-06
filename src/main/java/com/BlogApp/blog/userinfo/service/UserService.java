package com.BlogApp.blog.userinfo.service;

import com.BlogApp.blog.userinfo.Repository.RoleRepo;
import com.BlogApp.blog.userinfo.Repository.UserInfoRepo;
import com.BlogApp.blog.userinfo.model.Role;
import com.BlogApp.blog.userinfo.model.RoleName;
import com.BlogApp.blog.userinfo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {
@Autowired
private UserInfoRepo userInfoRepo;
@Autowired
private RoleRepo roleRepo;
@Autowired
PasswordEncoder passwordEncoder;

public ResponseEntity<String> addUser(UserInfo  user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userInfoRepo.save(user);
        return ResponseEntity.ok("User save successfully.");
}


@PostConstruct
private void saveUser(){

        Optional<Role> optional=roleRepo.findByRoleName(RoleName.SUPER_ADMIN);
        if (!optional.isPresent()) {
                UserInfo userInfo = new UserInfo();

                userInfo.setFirstName("deepak");
                userInfo.setMiddleName("");
                userInfo.setLastName("saud");
                userInfo.setEmail("deepak@gmail.com");
                userInfo.setPassword(passwordEncoder.encode("deepak@1234"));

                Set<Role> roleList = new HashSet<>();

                Role role = new Role();

                role.setRoleName(RoleName.SUPER_ADMIN);
                roleList.add(role);

                userInfo.setRoles(roleList);
                userInfoRepo.save(userInfo);
        }
    }
}
