package com.service.impl;

import com.dao.PostDao;
import com.domain.Post;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> selectPost(Post post){
        return postDao.selectPost(post);
    }

    @Override
    public int insertPost(Post post){
        int rows = postDao.insertPost(post);
        return rows;
    }

    @Override
    public int updatePost(Post post){
        int rows = postDao.updatePost(post);
        return rows;
    }

    @Override
    public int deletePostById(int id){
        return postDao.deletePostById(id);
    }
}
