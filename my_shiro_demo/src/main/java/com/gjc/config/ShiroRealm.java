package com.gjc.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gjc.entity.AuthDO;
import com.gjc.entity.RoleDO;
import com.gjc.entity.UserDO;
import com.gjc.service.IAuthService;
import com.gjc.service.IRoleService;
import com.gjc.service.IUserService;
import com.gjc.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IAuthService authService;
    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserDO sysUserEntity = (UserDO) principalCollection.getPrimaryPrincipal();
        //获取用户ID
        Integer userId =sysUserEntity.getUserId();
        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();
        Set<String> permsSet = new HashSet<>();
        //查询角色和权限(这里根据业务自行查询)
        List<RoleDO> roleDOList = roleService.selectSysRoleByUserId(userId);
        for (RoleDO roleDO:roleDOList) {
            rolesSet.add(roleDO.getRoleName());
            List<AuthDO> authDOList = authService.selectSysMenuByRoleId(roleDO.getRoleId());
            for (AuthDO authDO :authDOList) {
                permsSet.add(authDO.getPermission());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        authorizationInfo.setStringPermissions(permsSet);
        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        QueryWrapper<UserDO> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(UserDO::getUsername, username);
        UserDO user = userService.getOne(userQueryWrapper);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        if (user.getUserStatus()==null||user.getUserStatus().equals("PROHIBIT")){
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getPassword(),                    //密码
                ByteSource.Util.bytes(user.getSalt()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
//        ShiroUtils.deleteCache(username,true);
        return authenticationInfo;
    }

}
