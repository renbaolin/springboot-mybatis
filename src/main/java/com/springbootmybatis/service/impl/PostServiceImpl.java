package com.springbootmybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbootmybatis.dal.dao.PostDao;
import com.springbootmybatis.dal.domain.Post;
import com.springbootmybatis.service.PostService;

/**
 * Created by beike on 2017/3/8.
 */
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    public Post queryPostById(Long id){
        Post post = postDao.queryPostById(id);
        return post;
    }

    public List<Post> queryPostByTag(Long tag){
        return postDao.queryPostByTag(tag);
    }
}
