package com.xiaohu.auth.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @PackgeName: com.xiaohu.auth.domain.vo
 * @ClassName: LoginVo
 * @Author: xiaohu
 * Date: 2021/5/6 12:12
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginVo implements Serializable {

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "密码")
    private String password;
}
