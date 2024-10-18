package com.sakura.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.admin.model.entity.system.SysMenu;
import com.sakura.admin.model.vo.system.SysMenuVo;

import java.util.List;
import java.util.Map;

/**
 * @author sakura
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service
 * @createDate 2024-10-02 17:34:12
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询菜单列表
     *
     * @return 菜单列表
     */
    List<SysMenuVo> listMenu();

    /**
     * 构建菜单树
     *
     * @param menu       菜单列表
     * @param pid        父级ID
     * @param isOnlyMenu 是否只获取菜单
     * @return 菜单树
     */
    List<SysMenuVo> buildMenuTree(List<SysMenu> menu, Long pid, boolean isOnlyMenu);

    /**
     * 根据用户ID获取权限列表
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    Map<String, List<String>> getPermissionsByUserId(Long userId);
}
