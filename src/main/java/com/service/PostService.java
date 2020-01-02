package com.service;

import com.domain.Post;

import java.util.List;

public interface PostService {

    List<Post> selectPost(Post post);

    int insertPost(Post post);

    int updatePost(Post Post);

    int deletePostById(int id);
}
