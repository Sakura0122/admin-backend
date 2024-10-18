package com.sakura.admin.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.admin.system.mapper.SysRoleMapper;
import com.sakura.admin.system.service.SysRoleMenuService;
import com.sakura.admin.system.service.SysRoleService;
import com.sakura.admin.system.service.SysUserRoleService;
import com.sakura.admin.model.dto.system.role.SysRoleQueryDto;
import com.sakura.admin.model.entity.system.SysRole;
import com.sakura.admin.model.entity.system.SysUserRole;
import com.sakura.admin.common.PageVo;
import com.sakura.admin.common.ResultCodeEnum;
import com.sakura.admin.model.vo.system.SysRoleVo;
import com.sakura.admin.exception.SakuraException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sakura
 * @description 针对表【sys_role(角色)】的数据库操作Service实现
 * @createDate 2024-10-02 17:34:12
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public PageVo<SysRoleVo> roleListPage(SysRoleQueryDto sysRoleQueryDto) {
        // 1. 获取参数
        String roleName = sysRoleQueryDto.getRoleName();

        // 2. 获取分页查询条件
        Page<SysRole> p = sysRoleQueryDto.toMpPageDefaultSortByUpdateTimeDesc();

        // 3.查询
        Page<SysRole> page = lambdaQuery()
                .like(StrUtil.isNotBlank(roleName), SysRole::getRoleName, roleName)
                .page(p);

        // 4.返回数据
        return PageVo.of(page, SysRoleVo.class);
    }

    @Override
    public List<Long> getRoleById(Long id) {
        if (id == null) {
            throw new SakuraException(ResultCodeEnum.PARAM_ERROR);
        }
        List<SysUserRole> list = sysUserRoleService.lambdaQuery().eq(SysUserRole::getUserId, id).list();
        return list.stream().map(SysUserRole::getRoleId).toList();
    }
}




