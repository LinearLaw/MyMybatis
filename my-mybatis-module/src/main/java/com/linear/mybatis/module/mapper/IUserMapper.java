package com.linear.mybatis.module.mapper;

import com.linear.mybatis.module.domain.User;

import java.util.List;

public interface IUserMapper {

    List<User> findAll();

}
