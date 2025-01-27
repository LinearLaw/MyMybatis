package com.linear.mybatis.app.test;

import com.linear.mybatis.app.domain.User;
import com.linear.mybatis.app.mapper.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) {
        SqlSession session = null;
        InputStream in = null;
        try {
            // 路径前缀默认是resources目录
            in = Resources.getResourceAsStream("SqlMapConfig.xml");

            // 构建者模式，将读取的xml配置给builder，从而创建初SqlSessionFactory
            // 对象的创建过程隐藏，使用者调用方法即可得到对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);

            // 工厂模式，解耦，减少类之间的依赖
            session = factory.openSession();

            // 代理模式，不修改源码，对原对象增强从而实现指定功能
            IUserMapper mapper = session.getMapper(IUserMapper.class);
            List<User> all = mapper.findAll();

            for (User user : all) {
                System.out.println(user);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
