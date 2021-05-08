package com.xiaohu.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaohu.auth.domain.ImUser;
import com.xiaohu.auth.domain.vo.LoginVo;
import com.xiaohu.auth.domain.vo.RegisterVo;
import com.xiaohu.auth.mapper.ImUserMapper;
import com.xiaohu.auth.service.ImUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohu.core.domain.Result;
import com.xiaohu.core.utils.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2021-04-30
 */
@Service
public class ImUserServiceImpl extends ServiceImpl<ImUserMapper, ImUser> implements ImUserService {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public Result<String> login(LoginVo loginVo) {
        //
        QueryWrapper<ImUser> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("login_name",loginVo.getLoginName());
        queryWrapper.eq("password", DigestUtils.md5DigestAsHex(loginVo.getPassword().getBytes(StandardCharsets.UTF_8)));

        ImUser imUser = baseMapper.selectOne(queryWrapper);
        if (imUser != null) {
            String token = jwtUtils.generateToken(imUser.getId(), imUser.getUsername());
            return Result.ok(token,"登录成功");
        }

        return Result.fail("账号或密码错误");
    }

    @Override
    public Result<String> register(RegisterVo registerVo) {

        //TODO参数校验不能为空
        if (!registerVo.getPassword().equals(registerVo.getConfirmPassword())) {
            return Result.fail("俩次密码不一致");
        }
        //判断用户名是否存在
        QueryWrapper<ImUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",registerVo.getLoginName());
        ImUser selectUser = baseMapper.selectOne(queryWrapper);
        if (selectUser!=null) {
            return Result.fail("此账号已被注册");
        }

        String newPassword = DigestUtils.md5DigestAsHex(registerVo.getConfirmPassword().getBytes(StandardCharsets.UTF_8));
        ImUser imUser = new ImUser();
        BeanUtils.copyProperties(registerVo,imUser);
        imUser.setPassword(newPassword);
        //默认图片
        imUser.setAvater("https://pic.netbian.com/uploads/allimg/210505/234308-16202293881b20.jpg");
        int result = baseMapper.insert(imUser);

        if (result>0) {
            return Result.ok("注册用户成功");
        }
        return Result.fail("注册失败");
    }


}
