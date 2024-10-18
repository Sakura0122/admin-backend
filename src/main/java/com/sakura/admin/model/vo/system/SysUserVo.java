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
@Schema(description = "用户信息")
public class SysUserVo {

    @Schema(description = "用户ID")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "用户状态：1-正常，0-停用")
    private Integer status;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "修改时间")
    private Date updateTime;
}
