package com.sakura.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.admin.system.mapper.SysMenuMapper;
import com.sakura.admin.system.service.SysMenuService;
import com.sakura.admin.system.service.SysRoleMenuService;
import com.sakura.admin.system.service.SysRoleService;
import com.sakura.admin.model.entity.system.SysMenu;
import com.sakura.admin.model.vo.system.SysMenuVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sakura
 * @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
 * @createDate 2024-10-02 17:34:12
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysMenuVo> listMenu() {
        List<SysMenu> list = lambdaQuery().orderByAsc(SysMenu::getCreateTime).list();
        return this.buildMenuTree(list, 0L, true);
    }

    @Override
    public List<SysMenuVo> buildMenuTree(List<SysMenu> menu, Long pid, boolean isOnlyMenu) {
        // 1.创建空集合
        ArrayList<SysMenuVo> list = new ArrayList<>();

        // 2.判断menu是否为空
        if (CollUtil.isEmpty(menu)) {
            return list;
        }


        // 3.递归获取权限树
        for (SysMenu sysMenu : menu) {
            // // 3.1.判断是否为父级
            if (sysMenu.getParentId().equals(pid)) {
                SysMenuVo sysMenuVo = new SysMenuVo();
                BeanUtil.copyProperties(sysMenu, sysMenuVo);
                sysMenuVo.setChildren(this.buildMenuTree(menu, sysMenu.getId(), isOnlyMenu));
                list.add(sysMenuVo);
            }
        }

        return list;
    }

    @Override
    public Map<String, List<String>> getPermissionsByUserId(Long userId) {
        List<Long> roleIds = sysRoleService.getRoleById(userId);

        List<Long> menuIds = sysRoleMenuService.getMenuIdsByRoleIds(roleIds);

        List<SysMenu> list = lambdaQuery().in(SysMenu::getId, menuIds).list();

        List<String> routes = list.stream().filter(sysMenu -> !sysMenu.getType().equals(3)).map(SysMenu::getComponent).toList();
        List<String> buttons = list.stream().filter(sysMenu -> sysMenu.getType().equals(3)).map(SysMenu::getComponent).toList();

        return Map.of("routes", routes, "buttons", buttons);
    }

}




