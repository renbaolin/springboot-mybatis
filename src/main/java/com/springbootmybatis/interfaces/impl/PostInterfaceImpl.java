package com.springbootmybatis.interfaces.impl;

import com.springbootmybatis.interfaces.PostInterface;

public class PostInterfaceImpl implements PostInterface {
    @Override
    public String insertPost() {
        return "Post Insert Code";
    }
}
