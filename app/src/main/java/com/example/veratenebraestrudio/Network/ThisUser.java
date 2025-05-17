package com.example.veratenebraestrudio.Network;

import DataFiles.UserEntity;

public class ThisUser {
    private static ThisUser instance;
    private UserEntity currentUser;

    private ThisUser() {}

    public static synchronized ThisUser getInstance() {
        if (instance == null) {
            instance = new ThisUser();
        }
        return instance;
    }

    public void setCurrentUser(UserEntity user) {
        this.currentUser = user;
    }

    public UserEntity getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void clearSession() {
        currentUser = null;
    }
}
