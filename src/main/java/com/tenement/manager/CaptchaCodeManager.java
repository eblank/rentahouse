package com.tenement.manager;

import com.tenement.mapper.CaptchaCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LXPENG on 2016/4/25.
 */
@Service
public class CaptchaCodeManager {
    @Autowired
    private CaptchaCodeMapper captchaCodeMapper;


}
