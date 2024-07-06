package com.BlogApp.blog.blog.repository;

import com.BlogApp.blog.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    public List<Post> findByStatus(boolean status);

}
