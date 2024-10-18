package com.sakura.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.admin.model.dto.system.role.SysRoleQueryDto;
import com.sakura.admin.model.entity.system.SysRole;
import com.sakura.admin.common.PageVo;
import com.sakura.admin.model.vo.system.SysRoleVo;

import java.util.List;

/**
* @author sakura
* @description 针对表【sys_role(角色)】的数据库操作Service
* @createDate 2024-10-02 17:34:12
*/
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色列表
     * @param sysRoleQueryDto 查询条件
     * @return 用户列表
     */
    PageVo<SysRoleVo> roleListPage(SysRoleQueryDto sysRoleQueryDto);

    /**
     * 根据用户id获取角色列表
     * @param id 用户id
     * @return 角色id集合
     */
    List<Long> getRoleById(Long id);
}
