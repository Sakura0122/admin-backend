package com.sakura.admin.model.dto.system.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author: sakura
 * @date: 2024/10/14 09:12
 * @description:
 */
@Data
@Schema(description = "菜单新增参数")
public class SysMenuUpdateDto {

    @Schema(description = "菜单ID")
    @NotNull(message = "菜单ID不能为空")
    private Long id;

    @Schema(description = "菜单标题")
    @NotBlank(message = "菜单标题不能为空")
    private String title;

    @Schema(description = "菜单名称")
    @NotBlank(message = "菜单名称不能为空")
    private String component;


    @Schema(description = "菜单类型")
    @NotNull(message = "菜单类型不能为空")
    private Integer type;

    @Schema(description = "排序")
    private Integer sortValue;

    @Schema(description = "菜单状态")
    private Integer status;
}
