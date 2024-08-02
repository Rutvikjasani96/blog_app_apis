package com.blog_app_apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog_app_apis.payloads.ApiResponse;
import com.blog_app_apis.payloads.PostDto;
import com.blog_app_apis.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable("userId") int userId,@PathVariable("categoryId") int categoryId){
        PostDto createdPost = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
    }

    @PutMapping("post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable("postId") int postId){
        PostDto updatedPost = postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
    }

    @DeleteMapping("post/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") int postId){
        postService.deletePost(postId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully...",true), HttpStatus.OK);
    }


    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId") int postId){
        PostDto post = postService.getPostById(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(
        @RequestParam(value = "pageNumber", defaultValue = "0",required = false) int pageNumber, 
        @RequestParam(value="pageSize", defaultValue = "10", required = false) int pageSize){
        List<PostDto> posts = postService.getAllPost(pageNumber,pageSize);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") int categoryId){
        List<PostDto> posts = postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("userId") int userId){
        List<PostDto> posts = postService.getPostByUser(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
}
