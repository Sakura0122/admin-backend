package com.sakura.admin.model.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表
 *
 * @TableName sys_menu
 */
@TableName(value = "sys_menu")
@Data
public class SysMenu implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 所属上级
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 组件名称
     */
    @TableField(value = "component")
    private String component;

    /**
     * 菜单类型(1:目录,2:菜单,3:按钮)
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 排序
     */
    @TableField(value = "sort_value")
    private Integer sortValue;

    /**
     * 状态(0:禁止,1:正常)
     */
    @TableField(value = "status")
    private Integer status;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
