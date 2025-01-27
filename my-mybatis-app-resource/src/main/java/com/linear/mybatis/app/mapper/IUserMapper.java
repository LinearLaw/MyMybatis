package com.linear.mybatis.app.mapper;

import com.linear.mybatis.app.domain.User;

import java.util.List;

public interface IUserMapper {

    List<User> findAll();

}
