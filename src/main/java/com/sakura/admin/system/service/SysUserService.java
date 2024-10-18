package com.sakura.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.admin.model.dto.system.user.LoginDto;
import com.sakura.admin.model.dto.system.user.SysUserAddDto;
import com.sakura.admin.model.dto.system.user.SysUserQueryDto;
import com.sakura.admin.model.entity.system.SysUser;
import com.sakura.admin.common.PageVo;
import com.sakura.admin.model.vo.system.LoginVo;
import com.sakura.admin.model.vo.system.SysUserVo;
import com.sakura.admin.model.vo.system.UserInfoVo;
import com.sakura.admin.model.vo.system.ValidateCodeVo;

/**
* @author sakura
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2024-10-02 17:34:12
*/
public interface SysUserService extends IService<SysUser> {

    /**
     * 登录
     * @param loginDto 登录表单
     * @return token
     */
    LoginVo login(LoginDto loginDto);

    /**
     * 获取验证码
     * @return 验证码
     */
    ValidateCodeVo validateCode();

    /**
     * 获取用户信息
     * @param token token
     * @return 用户信息
     */
    UserInfoVo info(String token);

    /**
     * 退出登录
     * @param token token
     */
    void logout(String token);

    /**
     * 分页查询用户列表
     * @param sysUserQueryDto 分页参数
     * @return 用户列表
     */
    PageVo<SysUserVo> userListPage(SysUserQueryDto sysUserQueryDto);

    /**
     * 新增用户
     * @param sysUserAddDto 新增用户参数
     */
    void saveSysUser(SysUserAddDto sysUserAddDto);
}
