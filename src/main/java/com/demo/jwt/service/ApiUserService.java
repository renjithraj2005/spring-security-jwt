package com.demo.jwt.service;

import com.demo.jwt.model.User;

import javax.servlet.http.HttpServletRequest;

public interface ApiUserService {

    public String logIn(String username, String password);

    public boolean signUp(User user);

    public void delete(User user);

    public String refresh(String username);

    public User getUser(HttpServletRequest req);
}
