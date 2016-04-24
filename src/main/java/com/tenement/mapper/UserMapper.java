package com.tenement.mapper;

import com.tenement.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    User selectByAccount(String email);

    int updateByPrimaryKey(User record);
}