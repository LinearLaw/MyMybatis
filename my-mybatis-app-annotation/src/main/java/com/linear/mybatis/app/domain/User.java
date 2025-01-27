package com.linear.mybatis.app.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private LocalDateTime birthday;
    private String gender;
    private String address;
}
