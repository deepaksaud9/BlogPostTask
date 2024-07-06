package com.BlogApp.blog.blog.service;

import com.BlogApp.blog.blog.model.Comment;

import java.util.List;

public interface CommentService {

    public Comment saveComment(Comment comment);
    public Comment updateComment(long commentId, Comment comment);
    public String DeleteComment(long commentId);
    public List<Comment> getAllComments();
}
