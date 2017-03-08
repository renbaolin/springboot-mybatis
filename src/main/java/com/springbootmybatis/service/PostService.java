package com.springbootmybatis.service;

import java.util.List;

import com.springbootmybatis.dal.domain.Post;

/**
 * Created by beike on 2017/3/7.
 */
public interface PostService {

    Post queryPostById(Long id);

    List<Post> queryPostByTag(Long tag);
}
