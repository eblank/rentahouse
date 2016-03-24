package com.tenement.mapper;

import com.tenement.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(User record);

}