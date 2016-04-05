package com.tenement.mapper;

import com.tenement.model.User;
import com.tenement.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User record);
}