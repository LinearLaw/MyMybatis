package com.linear.mybatis.module.test;

import com.linear.mybatis.module.domain.Role;
import com.linear.mybatis.module.domain.User;
import com.linear.mybatis.module.mapper.IRoleMapper;
import com.linear.mybatis.module.mapper.IUserMapper;
import com.linear.mybatis.module.mymybatis.io.Resources;
import com.linear.mybatis.module.mymybatis.sqlsession.SqlSession;
import com.linear.mybatis.module.mymybatis.sqlsession.SqlSessionFactory;
import com.linear.mybatis.module.mymybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试my-mybatis
 */
public class MyMybatisTest {
    public static void main(String[] args) {
        InputStream in = null;
        SqlSession session = null;

        try {
            //1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //3.使用工厂生产SqlSession对象
            session = factory.openSession();

            // 4、执行具体的sql语句
            System.out.println("------------ start test xml ------------");
            testXml(session);

            System.out.println("------------ start test annotation ------------");
            testAnnotation(session);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 5、关闭资源
            if (session != null) {
                session.close();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void testXml(SqlSession session) {
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void testAnnotation(SqlSession session) {
        IRoleMapper roleMapper = session.getMapper(IRoleMapper.class);
        List<Role> roles = roleMapper.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
