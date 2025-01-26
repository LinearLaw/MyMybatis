package com.linear.mybatis.app.dao;

import com.linear.mybatis.app.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

}
