package com.tenement.mapper;

import com.tenement.model.CaptchaCode;

public interface CaptchaCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CaptchaCode record);

    int insertSelective(CaptchaCode record);

    CaptchaCode selectByPrimaryKey(Long id);

    CaptchaCode selectBySelective(CaptchaCode captchaCode);

    int updateByPrimaryKeySelective(CaptchaCode record);

    int updateByPrimaryKey(CaptchaCode record);
}