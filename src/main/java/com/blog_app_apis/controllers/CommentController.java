package com.blog_app_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog_app_apis.payloads.ApiResponse;
import com.blog_app_apis.payloads.CommentDto;
import com.blog_app_apis.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @PostMapping("user/{userId}/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
        @RequestBody CommentDto commentDto,
        @PathVariable("postId") int postId
    ){
        CommentDto createdComment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(createdComment,HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable("commentId") int commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment Deleted Successfullt...",true),HttpStatus.OK);
    }
}
