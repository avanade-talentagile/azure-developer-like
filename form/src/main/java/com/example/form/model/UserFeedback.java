package com.example.form.model;
import java.util.UUID;
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

    public UserFeedback() {
    }

    public UserFeedback(String userId, String title, String comment) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.title = title;
        this.comment = comment;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
