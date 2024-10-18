package com.sakura.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.admin.model.dto.system.user.SetRoleDto;
import com.sakura.admin.model.entity.system.SysUserRole;

/**
* @author sakura
* @description 针对表【sys_user_role(用户角色)】的数据库操作Service
* @createDate 2024-10-02 17:34:12
*/
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 分配角色
     * @param setRoleDto 分配角色参数
     */
    void setRole(SetRoleDto setRoleDto);
}
