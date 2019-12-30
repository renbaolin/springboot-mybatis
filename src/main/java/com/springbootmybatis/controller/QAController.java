package com.springbootmybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmybatis.adapters.PostAdapter;
import com.springbootmybatis.interfaces.PostInterface;
import com.springbootmybatis.interfaces.impl.PostInterfaceImpl;

@RestController
@RequestMapping(value = "/api/qa")
public class QAController {

    @RequestMapping(value = "/insert")
    public String insertQA() {
        PostInterface postInterface = new PostInterfaceImpl();
        String s = postInterface.insertPost();
        PostInterface postAdapter = new PostAdapter();
        String ss = postAdapter.insertPost();
        return s + ss;
    }
}
