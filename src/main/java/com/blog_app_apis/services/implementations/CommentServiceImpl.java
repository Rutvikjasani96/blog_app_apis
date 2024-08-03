package com.blog_app_apis.services.implementations;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_app_apis.entities.Comment;
import com.blog_app_apis.entities.Post;
import com.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog_app_apis.payloads.CommentDto;
import com.blog_app_apis.repositories.CommentRespository;
import com.blog_app_apis.repositories.PostRepository;
import com.blog_app_apis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRespository commentRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto,int postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment createdComment = commentRespository.save(comment);
        return modelMapper.map(createdComment, CommentDto.class);
    }

    @Override
    public void deleteComment(int commentId) {
        Comment comment = commentRespository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", commentId));
        commentRespository.delete(comment);
    }   
    
}
