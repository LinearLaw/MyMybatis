package com.linear.mybatis.module.mymybatis.sqlsession;

import com.linear.mybatis.module.mapper.IUserMapper;

public interface SqlSession {
    void close();

    <T> T getMapper(Class<T> mapperClass);
}
