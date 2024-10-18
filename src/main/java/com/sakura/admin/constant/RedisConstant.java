package com.sakura.admin.constant;

/**
 * @author: sakura
 * @date: 2024/10/3 16:52
 * @description:
 */
public class RedisConstant {
    // 登录返回的token
    public static final String USER_LOGIN_TOKEN = "login:token:";
    public static final int USER_LOGIN_TOKEN_TIMEOUT = 60 * 30;

    // 验证码
    public static final String USER_LOGIN_TOKEN_KEY = "login:code:";
    public static final int USER_LOGIN_CODE_TIMEOUT = 60;
}
