package com.springbootmybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmybatis.dal.domain.Post;
import com.springbootmybatis.service.PostService;

/**
 * Created by beike on 2017/3/7.
 */
@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/detail")
    Post postDetail(@RequestParam(value = "id") Long id){
        return postService.queryPostById(id);
    }

    @RequestMapping(value = "/list")
    List<Post> postList(@RequestParam(value = "tag") Long tag){
        return postService.queryPostByTag(tag);
    }
}
