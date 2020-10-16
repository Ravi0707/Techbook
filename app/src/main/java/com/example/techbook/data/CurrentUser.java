package com.example.techbook.data;

import android.net.Uri;

public class CurrentUser {
    private String username;
    private Uri userImage;
    private String userEmail;
    private String uId;


    public CurrentUser(String username, Uri userImage, String userEmail,String uId) {
        this.username = username;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.uId = uId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Uri getUserImage() {
        return userImage;
    }

    public void setUserImage(Uri userImage) {
        this.userImage = userImage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
