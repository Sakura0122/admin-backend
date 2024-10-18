package com.sakura.admin.model.dto.system.role;

import com.sakura.admin.common.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "请求参数实体类")
public class SysRoleQueryDto extends PageDto {

    @Schema(description = "角色名称")
    private String roleName;

}
