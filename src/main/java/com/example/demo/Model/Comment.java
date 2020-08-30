package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    private int commentId;
    private String email;
    private String content;
    private String uploadTime;
    private Boolean isRead;
    private Integer commentBoxId;

    public Comment ()
    {
    }

    public int getCommentId ()
    {
        return commentId;
    }

    public void setCommentId (int commentId)
    {
        this.commentId = commentId;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getUploadTime ()
    {
        return uploadTime;
    }

    public void setUploadTime (String uploadTime)
    {
        this.uploadTime = uploadTime;
    }

    public Boolean getRead ()
    {
        return isRead;
    }

    public void setRead (Boolean read)
    {
        isRead = read;
    }

    public Integer getCommentBoxId ()
    {
        return commentBoxId;
    }

    public void setCommentBoxId (Integer commentBoxId)
    {
        this.commentBoxId = commentBoxId;
    }

    @Override
    public String toString ()
    {
        return "Comment{" + "commentId=" + commentId + ", email='" + email + '\'' + ", content='" + content + '\'' + ", uploadTime='" + uploadTime + '\'' + ", isRead=" + isRead + ", commentBoxId=" + commentBoxId + '}';
    }
}
