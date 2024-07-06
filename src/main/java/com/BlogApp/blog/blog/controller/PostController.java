package com.BlogApp.blog.blog.controller;

import com.BlogApp.blog.blog.model.Post;
import com.BlogApp.blog.blog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/savePost")
    public Post createPost(@RequestBody Post post){
       return postService.savePost(post);
    }

    @PutMapping("/updatePost/{postId}")
    public Post updatePost(@PathVariable long postId, @RequestBody Post post){
        return postService.updatePost(postId,post);
    }

    @GetMapping("/findAllPost")
    public List<Post> getAllPost(){
        return postService.findAllActivePost();
    }

    @PutMapping("/deletePost/{postId}")
    public String deletePost(@PathVariable long postId){
        return postService.deletePost(postId);
    }

}
