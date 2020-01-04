package com.dao;
import com.domain.Post;
import java.util.List;

public interface PostDao {

    List<Post> selectPost(Post post);

    Post selectPostByPostName(String postName);

    int insertPost(Post post);

    int updatePost(Post Post);

    int deletePostById(int id);
}
