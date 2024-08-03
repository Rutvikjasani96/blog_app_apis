package com.blog_app_apis.services;

import com.blog_app_apis.payloads.CommentDto;

public interface CommentService {
    public CommentDto createComment(CommentDto commentDto, int postId);

    public void deleteComment(int commentId);
}
