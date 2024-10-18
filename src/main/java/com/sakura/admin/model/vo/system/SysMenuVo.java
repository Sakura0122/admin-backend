package com.sakura.admin.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: sakura
 * @date: 2024/10/13 22:26
 * @description:
 */
@Data
@Schema(description = "菜单")
public class SysMenuVo {
    @Schema(description = "菜单ID")
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

    @Schema(description = "子菜单")
    private List<SysMenuVo> children;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "修改时间")
    private Date updateTime;
}
