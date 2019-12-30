package com.springbootmybatis.adapters;

import com.springbootmybatis.adaptees.QAAdaptee;
import com.springbootmybatis.interfaces.PostInterface;

public class PostAdapter extends QAAdaptee implements PostInterface {

    @Override
    public String insertPost() {
        return super.insertQA();
    }
}
