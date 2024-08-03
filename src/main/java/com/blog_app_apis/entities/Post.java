package com.blog_app_apis.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog_app_apis.payloads.CommentDto;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(name = "title",nullable = false,length = 100)
    private String postTitle;
    @Column(name = "content",length = 1000)
    private String postContent;
    @Column(name = "imgname")
    private String postImgName;
    @Column(name = "addeddate")
    private Date postAddedDate;
    
    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;
}
