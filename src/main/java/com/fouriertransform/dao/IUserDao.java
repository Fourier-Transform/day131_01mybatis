package com.fouriertransform.dao;

import com.fouriertransform.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll() ;
    void saveUser(User user);
    void updateUser(User user);
}
