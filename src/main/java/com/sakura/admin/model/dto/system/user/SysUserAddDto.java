package com.sakura.admin.model.dto.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author: sakura
 * @date: 2024/10/11 15:28
 * @description:
 */
@Data
@Schema(description = "新增用户")
public class SysUserAddDto {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    @Min(value = 6, message = "密码长度不能小于6")
    private String password;

    @Schema(description = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Schema(description = "手机号")
    private String phone;


    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "用户状态：1-正常，0-停用")
    private Integer status;
}
