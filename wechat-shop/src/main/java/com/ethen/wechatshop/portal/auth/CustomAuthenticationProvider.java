package com.ethen.wechatshop.portal.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义身份验证组件
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        //认证逻辑 fixme 后期待改进，当前先做个demo @date 2018/5/20
        if ("ethen".equals(name) && "123".equals(password)) {
            //这里设置权限和角色
            List<GrantedAuthority> authorities = new LinkedList<>();
            authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));//角色
            authorities.add(new GrantedAuthorityImpl("AUTH_WRITE"));//权限
            //生成令牌
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
            return auth;
        } else {
            throw new BadCredentialsException("用户名或密码错误~");
        }

    }

    // 是否可以提供输入类型的认证服务
    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
