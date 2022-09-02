package com.example.functions.model;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "user_feedback")
public class UserFeedback {

    @Id
    private String id;
    @PartitionKey
    private String userId;
    private String title;
    private String comment;
    private String url;

    public UserFeedback() {
        this.title = "Static title";
    }

    public String getId() {return id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
