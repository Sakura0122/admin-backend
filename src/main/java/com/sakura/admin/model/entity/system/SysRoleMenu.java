package com.sakura.admin.model.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色菜单
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
public class SysRoleMenu implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     *
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     *
     */
    @TableField(value = "menu_id")
    private Long menuId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 删除标记（0:不可用 1:可用）
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     *
     */
    @TableField(value = "is_half")
    private Integer isHalf;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
