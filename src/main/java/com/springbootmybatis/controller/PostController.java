package com.springbootmybatis.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
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

    private static final String VIDEO_REG = "\\[media(\\=([a-zA-Z0-9_-]+)\\,(\\d+)\\,(\\d+)\\,([a-zA-Z0-9_-]+))?\\](.*?)\\[\\/media\\]";  //视频标签

    private static final String VIDEO_FORMAT =
            "<embed src='%s' allowFullScreen='true' quality='high' width='%s' height='%s' class='%s' align='middle' allowScriptAccess='always' type='application/x-shockwave-flash'></embed>";
    private static final String DEFAULT_WIDTH = "600";
    private static final String DEFAULT_HEIGHT = "500";
    private static final String DEFAULT_CLASS_NAME = "editor-block-video";

    @RequestMapping(value = "/detail")
    Post postDetail(@RequestParam(value = "id") Long id) {
        return postService.queryPostById(id);
    }

    @RequestMapping(value = "/list")
    List<Post> postList(@RequestParam(value = "tag") Long tag) {
        return postService.queryPostByTag(tag);
    }

    @RequestMapping(value = "/video")
    String parseVideoTag(@RequestParam(value = "message") String message) {
        if (StringUtils.isEmpty(message)) return message;
        Pattern pattern = Pattern.compile(VIDEO_REG, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            //[media]标签内容
            String oldMedia = matcher.group(0);
            //宽度
            String width = matcher.group(3);
            //高度
            String height = matcher.group(4);
            //html class
            String className = matcher.group(5);
            //视频地址
            String videoUrl = matcher.group(6);
            String newVideo = String.format(VIDEO_FORMAT, videoUrl, width, height, className);
            message = message.replace(oldMedia, newVideo);
        }
        return message;
    }

    /**
     * 清楚视频标签
     */
    private String clearVideoTag(String message) {
        String reg = "[media(.*?)](.*?)[\\/img]";
        return message.replaceAll(reg, "");
    }
}
