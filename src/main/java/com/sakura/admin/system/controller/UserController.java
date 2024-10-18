package com.sakura.admin.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.sakura.admin.model.dto.system.user.*;
import com.sakura.admin.system.service.SysUserRoleService;
import com.sakura.admin.system.service.SysUserService;
import com.sakura.admin.common.DeleteDto;
import com.sakura.admin.model.entity.system.SysUser;
import com.sakura.admin.common.PageVo;
import com.sakura.admin.common.Result;
import com.sakura.admin.model.vo.system.LoginVo;
import com.sakura.admin.model.vo.system.SysUserVo;
import com.sakura.admin.model.vo.system.UserInfoVo;
import com.sakura.admin.model.vo.system.ValidateCodeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: sakura
 * @date: 2024/10/2 20:24
 * @description:
 */
@RestController
@RequestMapping("/admin/user")
@Tag(name = "用户管理")
@Validated
public class UserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserRoleService sysUserRoleService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<LoginVo> login(@RequestBody @Valid LoginDto loginDto) {
        return Result.success(sysUserService.login(loginDto));
    }

    @GetMapping("/validateCode")
    @Operation(summary = "获取验证码")
    public Result<ValidateCodeVo> validateCode() {
        return Result.success(sysUserService.validateCode());
    }

    @GetMapping("/info")
    @Operation(summary = "获取用户信息")
    public Result<UserInfoVo> info(@RequestHeader("Authorization") String token) {
        return Result.success(sysUserService.info(token));
    }

    @GetMapping("/logout")
    @Operation(summary = "用户退出登录")
    public Result<Null> logout(@RequestHeader("Authorization") String token) {
        sysUserService.logout(token);
        return Result.success(null);
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询用户列表")
    public Result<PageVo<SysUserVo>> userListPage(@RequestBody @Validated SysUserQueryDto sysUserQueryDto) {
        return Result.success(sysUserService.userListPage(sysUserQueryDto));
    }

    @PostMapping("/add")
    @Operation(summary = "新增用户")
    public Result<Null> addUser(@RequestBody @Validated SysUserAddDto sysUserAddDto) {
        sysUserService.saveSysUser(sysUserAddDto);
        return Result.success(null);
    }

    @PostMapping("/update")
    @Operation(summary = "修改用户")
    public Result<Null> updateUser(@RequestBody @Validated SysUserUpdateDto sysUserUpdateDto) {
        sysUserService.updateById(BeanUtil.toBean(sysUserUpdateDto, SysUser.class));
        return Result.success(null);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除用户")
    public Result<Null> deleteUser(@RequestBody @Validated DeleteDto deleteDto) {
        sysUserService.removeById(deleteDto.getId());
        return Result.success(null);
    }

    @PostMapping("/setRole")
    @Operation(summary = "设置用户角色")
    public Result<Null> setRole(@RequestBody @Validated SetRoleDto setRoleDto) {
        sysUserRoleService.setRole(setRoleDto);
        return Result.success(null);
    }
}
