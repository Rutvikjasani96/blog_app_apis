package com.blog_app_apis.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private int postId;
    private String postTitle;
    private String postContent;
    private String postImgName;
    private Date postAddedDate;
    private CategoryDto category;
    private UserDto user;
}
