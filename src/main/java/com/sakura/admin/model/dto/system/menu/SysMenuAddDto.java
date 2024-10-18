package com.sakura.admin.model.dto.system.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: sakura
 * @date: 2024/10/14 09:12
 * @description:
 */
@Data
@Schema(description = "菜单新增参数")
public class SysMenuAddDto {
    @Schema(description = "父级菜单ID")
    private Long parentId;

    @Schema(description = "菜单标题")
    private String title;

    @Schema(description = "菜单名称")
    private String component;


    @Schema(description = "菜单类型")
    private Integer type;

    @Schema(description = "排序")
    private Integer sortValue;

    @Schema(description = "菜单状态")
    private Integer status;
}
