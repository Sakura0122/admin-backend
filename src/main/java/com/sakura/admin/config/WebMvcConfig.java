package com.sakura.admin.config;

import com.sakura.admin.interceptor.LoginAuthInterceptor;
import com.sakura.admin.properties.UserAuthProperties;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: sakura
 * @date: 2024/10/3 11:58
 * @description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private UserAuthProperties userAuthProperties;

    @Resource
    private LoginAuthInterceptor loginAuthInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      // 添加路径规则
                .allowCredentials(true)            // 是否允许在跨域的情况下传递Cookie
                .allowedOriginPatterns("*")        // 允许请求来源的域规则
                .allowedMethods("*")               // 允许所有的请求方法
                .allowedHeaders("*");              // 允许所有的请求头
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(userAuthProperties.getExcludePaths())
                .excludePathPatterns(
                        "/error",
                        "/favicon.ico",
                        "/v2/**",
                        "/v3/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/doc.html"
                );
    }
}
