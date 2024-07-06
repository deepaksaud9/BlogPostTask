package com.BlogApp.blog.userinfo.Repository;

import com.BlogApp.blog.userinfo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {

    public Optional<UserInfo> findByEmail(String email);


}
