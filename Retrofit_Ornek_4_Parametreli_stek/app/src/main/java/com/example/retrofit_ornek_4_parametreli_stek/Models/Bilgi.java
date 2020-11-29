package com.example.retrofit_ornek_4_parametreli_stek.Models;

public class Bilgi {
    private String name;
    private Integer postId;
    private Integer id;
    private String body;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Bilgi{" +
                "name='" + name + '\'' +
                ", postId=" + postId +
                ", id=" + id +
                ", body='" + body + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
