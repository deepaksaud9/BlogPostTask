package com.BlogApp.blog.blog.controller;

import com.BlogApp.blog.blog.model.Comment;
import com.BlogApp.blog.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/saveComment")
    public Comment createComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    @PutMapping("/updateComment/{commentId}")
    public Comment updateComment(@PathVariable long commentId, @RequestBody Comment comment){
        return commentService.updateComment(commentId,comment);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable long commentId){
        commentService.DeleteComment(commentId);
        return "Comment delete Successfully";
    }

    @GetMapping("/findAllComments")
    public List<Comment> getAllComment(){
        return commentService.getAllComments();
    }

}
