package com.xiaohu.auth.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaohu.auth.domain.ImUser;
import com.xiaohu.auth.domain.vo.LoginVo;
import com.xiaohu.auth.domain.vo.RegisterVo;
import com.xiaohu.auth.service.ImUserService;
import com.xiaohu.core.domain.Result;
import com.xiaohu.core.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2021-04-30
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/auth/user")
public class ImUserController {

    @Autowired
    ImUserService imUserService;

    @Autowired
    JwtUtils jwtUtils;

    @ApiOperation("用户登陆")
    @PostMapping("/login")
    public Result<String> login (LoginVo loginVo){
        //TODO 验证码验证
        Result<String>  result = imUserService.login(loginVo);

        return result;
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<String>  redister (RegisterVo registerVo) {
        //TODO 参数校验

        Result<String> result = imUserService.register(registerVo);

        return result;
    }

    @ApiOperation("根据token获取用户名")
    @GetMapping("/getUser")
    public Result<ImUser> getUser(String token) {
        //校验token会在网关层面弄，这里就不判断了
        Object id = jwtUtils.getIdFromToken(token);
        ImUser imUser = imUserService.getById(id.toString());
        //重要信息设置为空
        imUser.setPassword(null);
        return Result.ok(imUser,"获取成功");
    }



}

