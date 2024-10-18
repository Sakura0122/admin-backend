package com.sakura.admin.utils;

import com.sakura.admin.model.entity.system.SysUser;

/**
 * @author: sakura
 * @date: 2024/10/4 22:34
 * @description:
 */
public class UserContextUtil {
    // 创建一个ThreadLocal对象
    private static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();

    // 定义存储数据的静态方法
    public static void set(SysUser sysUser) {
        threadLocal.set(sysUser);
    }

    // 定义获取数据的方法
    public static SysUser get() {
        return threadLocal.get();
    }

    // 删除数据的方法
    public static void remove() {
        threadLocal.remove();
    }
}
