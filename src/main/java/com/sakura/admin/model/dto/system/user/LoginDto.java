package com.sakura.admin.model.dto.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "用户登录请求参数")
public class LoginDto {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Schema(description = "提交验证码")
    @NotBlank(message = "验证码不能为空")
    private String captcha;

    @Schema(description = "验证码key")
    @NotBlank(message = "验证码key不能为空")
    private String codeKey;

}
