package com.sakura.admin.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.admin.system.mapper.SysRoleMenuMapper;
import com.sakura.admin.system.service.SysRoleMenuService;
import com.sakura.admin.model.dto.system.role.SetMenuDto;
import com.sakura.admin.model.entity.system.SysRoleMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sakura
 * @description 针对表【sys_role_menu(角色菜单)】的数据库操作Service实现
 * @createDate 2024-10-02 17:34:12
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {


    @Override
    public List<Long> getMenuByRoleId(Long id) {
        List<SysRoleMenu> list = lambdaQuery().eq(SysRoleMenu::getRoleId, id).list();
        return list.stream().map(SysRoleMenu::getMenuId).toList();
    }

    @Override
    @Transactional
    public void setPermission(SetMenuDto setMenuDto) {
        // 1.删除角色之前所有的菜单
        LambdaQueryWrapper<SysRoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRoleMenu::getRoleId, setMenuDto.getRoleId());
        this.remove(wrapper);

        // 2.给角色设置菜单
        List<Long> menuIdList = setMenuDto.getMenuIdList();
        List<SysRoleMenu> list = menuIdList.stream().map(menuId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(setMenuDto.getRoleId());
            sysRoleMenu.setMenuId(menuId);
            return sysRoleMenu;
        }).toList();

        // 3.保存数据
        this.saveBatch(list);
    }

    @Override
    public List<Long> getMenuIdsByRoleIds(List<Long> roleIds) {
        if (CollUtil.isEmpty(roleIds)) {
            return List.of();
        }
        List<SysRoleMenu> list = lambdaQuery().in(SysRoleMenu::getRoleId, roleIds).list();
        return list.stream().map(SysRoleMenu::getMenuId).toList();
    }
}




