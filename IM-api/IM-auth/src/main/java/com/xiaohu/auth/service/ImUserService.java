package com.xiaohu.auth.service;

import com.xiaohu.auth.domain.ImUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohu.auth.domain.vo.LoginVo;
import com.xiaohu.auth.domain.vo.RegisterVo;
import com.xiaohu.core.domain.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 小狐
 * @since 2021-04-30
 */
public interface ImUserService extends IService<ImUser> {
    /**
     * 用户登录
     * @param loginVo
     * @return
     */
    Result<String> login(LoginVo loginVo);

    /**
     * 用户注册
     * @param registerVo
     * @return
     */
    Result<String> register(RegisterVo registerVo);
}
