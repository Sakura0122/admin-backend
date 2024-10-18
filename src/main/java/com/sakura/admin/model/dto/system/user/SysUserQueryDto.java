package com.sakura.admin.model.dto.system.user;

import com.sakura.admin.common.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Schema(description = "请求参数实体类")
@EqualsAndHashCode(callSuper = true)
public class SysUserQueryDto extends PageDto {

    @Schema(description = "搜索关键字")
    private String keywords;

    @Schema(description = "用户状态：1-正常，0-停用")
    private Integer status;

    @Schema(description = "开始时间")
    private String createTimeBegin;

    @Schema(description = "结束时间")
    private String createTimeEnd;

}
