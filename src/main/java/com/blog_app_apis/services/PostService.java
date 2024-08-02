package com.blog_app_apis.services;

import java.util.List;

import com.blog_app_apis.payloads.PostDto;
import com.blog_app_apis.payloads.PostResponse;

public interface PostService {
    // Create
    public PostDto createPost(PostDto postDto,int userId,int categoryId);
    // update
    public PostDto updatePost(PostDto postDto,int postId);
    // delete
    public void deletePost(int postId);
    // find by id
    public PostDto getPostById(int postId);
    // get all
    public PostResponse getAllPost(int pageNumber,int pageSize,String sortBy,String sortDir);
    // get all by category
    public List<PostDto> getPostByCategory(int categoryId);
    // get all by user
    public List<PostDto> getPostByUser(int userId);
    // get all that is searched
    public List<PostDto> searchPosts(String searchKeyword);
}
