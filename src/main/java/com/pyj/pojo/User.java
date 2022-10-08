package com.pyj.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String username;
    private String password;
    private Date date;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
