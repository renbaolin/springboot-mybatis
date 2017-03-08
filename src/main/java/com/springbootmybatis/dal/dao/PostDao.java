package com.springbootmybatis.dal.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.springbootmybatis.dal.domain.Post;


/**
 * Created by beike on 2017/3/7.
 */
@Component
public class PostDao {
    @Resource(name = "dbMybatisTemplate")
    private SqlSessionTemplate dbMybatisTemplate;

    public Post queryPostById(Long id){
        return this.dbMybatisTemplate.selectOne("post.queryPostById", id);
    }

    public List<Post> queryPostByTag(Long tag){
        return this.dbMybatisTemplate.selectList("post.queryPostByTag", tag);
    }
}
