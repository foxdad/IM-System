package com.xiaohu.auth.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @PackgeName: com.xiaohu.auth.domain.vo
 * @ClassName: RegisterVo
 * @Author: xiaohu
 * Date: 2021/5/6 12:31
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVo implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "确认密码")
    private String confirmPassword;

}
