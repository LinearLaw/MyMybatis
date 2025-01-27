package com.linear.mybatis.app.mapper;

import com.linear.mybatis.app.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {

    @Select("select * from user")
    List<User> findAll();

}
