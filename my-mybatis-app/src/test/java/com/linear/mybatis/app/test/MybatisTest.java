package com.linear.mybatis.app.test;

import com.linear.mybatis.app.dao.IUserDao;
import com.linear.mybatis.app.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) {
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            SqlSession session = factory.openSession();
            IUserDao mapper = session.getMapper(IUserDao.class);
            List<User> all = mapper.findAll();

            for (User user : all) {
                System.out.println(user);
            }

            session.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
