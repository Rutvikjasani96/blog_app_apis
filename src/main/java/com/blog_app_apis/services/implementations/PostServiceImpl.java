package com.blog_app_apis.services.implementations;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_app_apis.entities.Category;
import com.blog_app_apis.entities.Post;
import com.blog_app_apis.entities.User;
import com.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog_app_apis.payloads.PostDto;
import com.blog_app_apis.repositories.CategoryRepository;
import com.blog_app_apis.repositories.PostRepository;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.PostService;

@Service
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto postDto,int userId,int categoryId) {

        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User ID", userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setPostImgName("default.png");
        post.setPostAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post createdPost = postRepository.save(post);

        return modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, int postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public void deletePost(int postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    @Override
    public List<PostDto> getPostById(int postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");
    }

    @Override
    public List<PostDto> getAllPost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPost'");
    }

    @Override
    public List<PostDto> getPostByCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
        List<Post> byCategoryPost = postRepository.findByCategory(category);
        List<PostDto> postDtos = byCategoryPost.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
        List<Post> postsByUser = postRepository.findByUser(user);
        List<PostDto> postDtos = postsByUser.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String searchKeyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPosts'");
    }
    
}
