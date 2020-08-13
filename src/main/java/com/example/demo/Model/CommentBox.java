package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommentBox {
    @Id
    private int commentBoxId;
    private boolean canComment;
    private String email;
    private Integer listingId;

    public CommentBox() {}

    public CommentBox(int commentBoxId, boolean canComment, String email, Integer listingId) {
        this.commentBoxId = commentBoxId;
        this.canComment = canComment;
        this.email = email;
        this.listingId = listingId;
    }

    public int getCommentBoxId() {
        return commentBoxId;
    }

    public void setCommentBoxId(int commentBoxId) {
        this.commentBoxId = commentBoxId;
    }

    public boolean isCanComment() {
        return canComment;
    }

    public void setCanComment(boolean canComment) {
        this.canComment = canComment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    @Override
    public String toString() {
        return "CommentBox{" +
                "commentBoxId=" + commentBoxId +
                ", canComment=" + canComment +
                ", email='" + email + '\'' +
                ", listingId=" + listingId +
                '}';
    }
}
