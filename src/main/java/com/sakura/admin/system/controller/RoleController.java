package com.sakura.admin.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.sakura.admin.common.DeleteDto;
import com.sakura.admin.common.PageVo;
import com.sakura.admin.system.service.SysRoleMenuService;
import com.sakura.admin.system.service.SysRoleService;
import com.sakura.admin.model.dto.system.role.SetMenuDto;
import com.sakura.admin.model.dto.system.role.SysRoleAddDto;
import com.sakura.admin.model.dto.system.role.SysRoleQueryDto;
import com.sakura.admin.model.dto.system.role.SysRoleUpdateDto;
import com.sakura.admin.model.entity.system.SysRole;
import com.sakura.admin.common.Result;
import com.sakura.admin.model.vo.system.SysRoleVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Null;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: sakura
 * @date: 2024/10/10 15:55
 * @description:
 */
@RestController
@RequestMapping("/admin/role")
@Tag(name = "角色管理")
@Validated
public class RoleController {

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @GetMapping("/list")
    @Operation(summary = "查询所有角色")
    public Result<List<SysRoleVo>> roleList() {
        return Result.success(BeanUtil.copyToList(sysRoleService.list(), SysRoleVo.class));
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询角色列表")
    public Result<PageVo<SysRoleVo>> roleListPage(@RequestBody @Validated SysRoleQueryDto sysRoleQueryDto) {
        return Result.success(sysRoleService.roleListPage(sysRoleQueryDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取用户的角色信息")
    @Parameters({@Parameter(name = "id", description = "用户id", in = ParameterIn.PATH)})
    public Result<List<Long>> getRoleById(@PathVariable("id") Long id) {
        return Result.success(sysRoleService.getRoleById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "新增角色")
    public Result<Long> addRole(@RequestBody @Validated SysRoleAddDto sysRoleAddDto) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleAddDto, sysRole);
        sysRoleService.save(sysRole);
        return Result.success(sysRole.getId());
    }

    @PostMapping("/update")
    @Operation(summary = "修改角色")
    public Result<Null> addRole(@RequestBody @Validated SysRoleUpdateDto sysRoleUpdateDto) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleUpdateDto, sysRole);
        sysRoleService.updateById(sysRole);
        return Result.success(null);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除角色")
    public Result<Null> deleteRole(@RequestBody @Validated DeleteDto deleteDto) {
        sysRoleService.removeById(deleteDto.getId());
        return Result.success(null);
    }

    @PostMapping("/setMenu")
    @Operation(summary = "设置角色权限")
    public Result<Null> setPermission(@RequestBody @Validated SetMenuDto setMenuDto) {
        sysRoleMenuService.setPermission(setMenuDto);
        return Result.success(null);
    }
}
