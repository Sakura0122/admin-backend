package com.sakura.admin.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author: sakura
 * @date: 2024/10/9 14:21
 * @description:
 */
@Data
@Schema(description = "角色信息")
public class SysRoleVo {

    @Schema(description = "角色ID")
    private Long id;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "角色描述")
    private String description;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "修改时间")
    private Date updateTime;
}
