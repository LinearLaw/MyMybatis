package com.linear.mybatis.module.mymybatis.io;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAsStream(String sourceName){
        return Resources.class.getClassLoader().getResourceAsStream(sourceName);
    }
}
