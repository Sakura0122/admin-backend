package com.sakura.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.admin.model.dto.system.role.SetMenuDto;
import com.sakura.admin.model.entity.system.SysRoleMenu;

import java.util.List;

/**
* @author sakura
* @description 针对表【sys_role_menu(角色菜单)】的数据库操作Service
* @createDate 2024-10-02 17:34:12
*/
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 根据角色id获取菜单
     * @param id 角色id
     * @return 菜单
     */
    List<Long> getMenuByRoleId(Long id);

    /**
     * 设置角色菜单
     * @param setMenuDto 角色菜单参数
     */
    void setPermission(SetMenuDto setMenuDto);

    /**
     * 根据角色id集合获取菜单id
     * @param roleIds 角色id集合
     * @return 菜单id集合
     */
    List<Long> getMenuIdsByRoleIds(List<Long> roleIds);
}
