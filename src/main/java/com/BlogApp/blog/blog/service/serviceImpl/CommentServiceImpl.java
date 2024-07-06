package com.BlogApp.blog.blog.service.serviceImpl;

import com.BlogApp.blog.blog.model.Comment;
import com.BlogApp.blog.blog.repository.CommentRepository;
import com.BlogApp.blog.blog.service.CommentService;
import com.BlogApp.blog.exception.BlogExceptionClass;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {

        if (comment.getCommentDescription().equals("")){
            throw new BlogExceptionClass("Comment Should not be null");
        }
        comment.setPost(comment.getPost());
        comment.setCommentDate(new Date());
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(long commentId, Comment comment) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()){
            optionalComment.get().setUpdateDate(new Date());
            optionalComment.get().setCommentDescription(comment.getCommentDescription());
            commentRepository.save(optionalComment.get());
            return optionalComment.get();
        }else {
            throw new BlogExceptionClass("CommentId not found");
        }
    }

    @Override
    public String DeleteComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()){
            commentRepository.delete(optionalComment.get());
            return "your comment deleted Successfully";
        }else {
            throw new BlogExceptionClass("CommentId not found");
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
