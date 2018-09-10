package com.project.pradyotprakash.unnamed;

public class BlogPost {

    private String userName;
    private String blogPost;

    public BlogPost() {
    }

    public BlogPost(String userName, String blogPost) {
        this.userName = userName;
        this.blogPost = blogPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(String blogPost) {
        this.blogPost = blogPost;
    }

}
