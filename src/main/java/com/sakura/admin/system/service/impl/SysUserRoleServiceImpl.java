package com.sakura.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.admin.system.mapper.SysUserRoleMapper;
import com.sakura.admin.system.service.SysUserRoleService;
import com.sakura.admin.model.dto.system.user.SetRoleDto;
import com.sakura.admin.model.entity.system.SysUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sakura
 * @description 针对表【sys_user_role(用户角色)】的数据库操作Service实现
 * @createDate 2024-10-02 17:34:12
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    @Transactional
    public void setRole(SetRoleDto setRoleDto) {
        // 1. 删除用户之前的所有角色
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId, setRoleDto.getUserId());
        this.remove(wrapper);

        // 2. 构造用户角色数据
        List<Long> roleIdList = setRoleDto.getRoleIdList();
        List<SysUserRole> list = roleIdList.stream().map(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(setRoleDto.getUserId());
            sysUserRole.setRoleId(roleId);
            return sysUserRole;
        }).toList();

        // 3.保存数据
        this.saveBatch(list);
    }
}




