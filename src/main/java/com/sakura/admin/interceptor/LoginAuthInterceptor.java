package com.sakura.admin.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.sakura.admin.common.ResultCodeEnum;
import com.sakura.admin.constant.RedisConstant;
import com.sakura.admin.exception.SakuraException;
import com.sakura.admin.model.entity.system.SysUser;
import com.sakura.admin.utils.UserContextUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * @author: sakura
 * @date: 2024/10/4 22:34
 * @description:
 */
@Component
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求方式
        String method = request.getMethod();
        if ("OPTIONS".equals(method)) {      // 如果是跨域预检请求，直接放行
            return true;
        }

        // 获取token
        String token = request.getHeader("Authorization");
        if (StrUtil.isEmpty(token)) {
            throw new SakuraException(ResultCodeEnum.ACCOUNT_STOP.LOGIN_AUTH);
        }

        // 如果token不为空，那么此时验证token的合法性
        String sysUserInfoJson = redisTemplate.opsForValue().get(RedisConstant.USER_LOGIN_TOKEN + token);
        if (StrUtil.isEmpty(sysUserInfoJson)) {
            throw new SakuraException(ResultCodeEnum.LOGIN_AUTH);
        }

        // 将用户数据存储到ThreadLocal中
        SysUser sysUser = JSONUtil.toBean(sysUserInfoJson, SysUser.class);
        UserContextUtil.set(sysUser);

        // 重置Redis中的用户数据的有效时间
        redisTemplate.expire(RedisConstant.USER_LOGIN_TOKEN + token, RedisConstant.USER_LOGIN_TOKEN_TIMEOUT, TimeUnit.SECONDS);

        // 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextUtil.remove();  // 移除threadLocal中的数据
    }
}
