package com.springbootmybatis.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by beike on 2017/3/8.
 */
public class Post implements Serializable{
    private static final long serialVersionUID = -4347670775011008736L;
    private Long id;
    private String title;
    private String description;
    private String content;
    private Integer tag;
    private Integer type;
    private Long authorUid;
    private Date createdTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setAuthorUid(Long authorUid) {
        this.authorUid = authorUid;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public Integer getTag() {
        return tag;
    }

    public Integer getType() {
        return type;
    }

    public Long getAuthorUid() {
        return authorUid;
    }

    public Date getCreatedTime() {
        return createdTime;
    }
}
