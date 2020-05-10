package com.demo.jwt.service;

import com.demo.jwt.model.User;

public interface ApiUserService {

    public String logIn(String username, String password);

    public boolean signUp(User user);

    public void delete(User user);
}
