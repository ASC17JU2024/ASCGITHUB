package com.ecz.model;
 class User {
    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }
}