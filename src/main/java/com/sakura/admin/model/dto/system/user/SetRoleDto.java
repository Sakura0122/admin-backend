package com.sakura.admin.model.dto.system.user;

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
@Schema(description = "分配角色")
public class SetRoleDto {

    @Schema(description = "用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @Schema(description = "角色ID集合")
    private List<Long> roleIdList;

}
