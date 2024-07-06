package com.BlogApp.blog.userinfo.Repository;

import com.BlogApp.blog.userinfo.model.Role;
import com.BlogApp.blog.userinfo.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName admin);
}
