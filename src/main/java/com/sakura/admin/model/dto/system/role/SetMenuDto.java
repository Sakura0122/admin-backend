package com.sakura.admin.model.dto.system.role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author: sakura
 * @date: 2024/10/12 17:20
 * @description:
 */
@Data
@Schema(description = "分配权限")
public class SetMenuDto {

    @Schema(description = "角色ID")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @Schema(description = "权限ID集合")
    private List<Long> menuIdList;

}
