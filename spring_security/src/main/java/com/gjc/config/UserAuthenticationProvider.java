package com.gjc.config;

import com.gjc.config.entity.SelfUserEntity;
import com.gjc.entity.RoleDO;
import com.gjc.service.base.IRoleService;
import com.gjc.service.business.SelfUserDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义登录验证
 *
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private SelfUserDetailsService selfUserDetailsService;
    @Resource
    private IRoleService roleService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        Object code = request.getSession().getAttribute("code");

        // 获取表单输入中返回的用户名
        String userName = (String) authentication.getPrincipal();
        // 获取表单中输入的密码
        String password = (String) authentication.getCredentials();
        if (StringUtils.isBlank(userName)) {
            throw new UsernameNotFoundException("账号不存在");
        }
        if (StringUtils.isBlank(password)) {
            throw new UsernameNotFoundException("密码不存在");
        }
        SelfUserEntity userInfo = selfUserDetailsService.loadUserByUsername(userName);
        // 查询用户是否存在
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if (!new BCryptPasswordEncoder().matches(password, userInfo.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        // 还可以加一些其他信息的判断，比如用户账号已停用等判断
        if (userInfo.getUserStatus().equals("PROHIBIT")) {
            throw new LockedException("该用户已被冻结");
        }
        // 角色集合
        Set<GrantedAuthority> authorities = new HashSet<>();
        // 查询用户角色
        List<RoleDO> sysRoleEntityList = roleService.selectSysRoleByUserId(userInfo.getUserId());
        for (RoleDO role : sysRoleEntityList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        userInfo.setAuthorities(authorities);
        // 进行登录
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
