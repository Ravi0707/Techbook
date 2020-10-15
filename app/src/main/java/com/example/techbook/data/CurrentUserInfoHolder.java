package com.example.techbook.data;

import android.net.Uri;

public class CurrentUserInfoHolder {

    private static CurrentUserInfoHolder userInfoHolder = null;

    private CurrentUserInfoHolder() {
    }

    public static CurrentUserInfoHolder getInstance() {
        if (userInfoHolder == null) {
            userInfoHolder = new CurrentUserInfoHolder();
        }
        return userInfoHolder;
    }


    private CurrentUser user;

    public CurrentUser getItem() {
        return user;
    }

    public void setItem(CurrentUser user) {
        this.user = user;
    }

    public void setUserImage(Uri uri) {
        this.user.setUserImage(uri);
    }
}