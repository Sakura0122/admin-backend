package com.sakura.admin.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.sakura.admin.system.service.SysMenuService;
import com.sakura.admin.system.service.SysRoleMenuService;
import com.sakura.admin.common.DeleteDto;
import com.sakura.admin.model.dto.system.menu.SysMenuAddDto;
import com.sakura.admin.model.dto.system.menu.SysMenuUpdateDto;
import com.sakura.admin.model.entity.system.SysMenu;
import com.sakura.admin.common.Result;
import com.sakura.admin.model.vo.system.SysMenuVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: sakura
 * @date: 2024/10/13 22:21
 * @description:
 */
@RestController
@RequestMapping("/admin/menu")
@Validated
@Tag(name = "菜单管理")

public class MenuController {

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @GetMapping("/list")
    @Operation(summary = "获取菜单树")
    public Result<List<SysMenuVo>> listMenu() {
        return Result.success(sysMenuService.listMenu());
    }

    @GetMapping("/role/{id}")
    @Operation(summary = "根据角色id获取权限id集合")
    public Result<List<Long>> getMenuByRoleId(@PathVariable Long id) {
        return Result.success(sysRoleMenuService.getMenuByRoleId(id));
    }

    @PostMapping("/add")
    @Operation(summary = "新增菜单")
    public Result<Long> addMenu(@RequestBody @Validated SysMenuAddDto sysMenuAddDto) {
        SysMenu sysMenu = BeanUtil.copyProperties(sysMenuAddDto, SysMenu.class);
        sysMenuService.save(sysMenu);
        return Result.success(sysMenu.getId());
    }

    @PostMapping("/update")
    @Operation(summary = "修改菜单")
    public Result<Void> updateMenu(@RequestBody @Validated SysMenuUpdateDto sysMenuUpdateDto) {
        sysMenuService.updateById(BeanUtil.copyProperties(sysMenuUpdateDto, SysMenu.class));
        return Result.success(null);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除菜单")
    public Result<Void> deleteMenu(@RequestBody @Validated DeleteDto deleteDto) {
        sysMenuService.removeById(deleteDto.getId());
        return Result.success(null);
    }
}
