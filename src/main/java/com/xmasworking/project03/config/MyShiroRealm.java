package com.xmasworking.project03.config;

import com.xmasworking.project03.entity.LevelRole;
import com.xmasworking.project03.entity.TelInfo;
import com.xmasworking.project03.repository.LevelRoleRepository;
import com.xmasworking.project03.repository.TelInfoRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManagerAware;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 *
 *
 * @author XmasPiano
 * @date 2018/3/1 上午10:16
 * @param
 * @return
 */
public class MyShiroRealm extends AuthorizingRealm implements CacheManagerAware {
    @Value("${admin.loginid}")
    private String adminName;

    @Value("${admin.password}")
    private String password;

    @Value("${admin.lastname}")
    private String lastname;

    @Autowired
    private TelInfoRepository telinfoRepository;
    @Autowired
    private LevelRoleRepository levelroleRepository;

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        TelInfo telInfo = (TelInfo) principal.getPrimaryPrincipal();
        LevelRole levelRole = levelroleRepository.getOne(telInfo.getLevelid());
        authorizationInfo.addRole(levelRole.getName());
        return authorizationInfo;
    }

    /**
     * 认证.登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的token
        UsernamePasswordToken utoken=(UsernamePasswordToken) authenticationToken;
        String username = utoken.getUsername();

        TelInfo telInfo = new TelInfo();

        //如果用户名是管理员
        if(this.adminName.equals(username)) {
            telInfo.setTelno(adminName);
            //验证管理员
            return new SimpleAuthenticationInfo(telInfo, this.password, getName());
        }
        //验证用户
        try {
            telInfo = new TelInfo();
            telInfo.setTelno(username);
            Example<TelInfo> example = Example.of(telInfo);
            Optional<TelInfo> optional = telinfoRepository.findOne(example);

            if(optional.isPresent()) {
                telInfo = optional.get();
            }else {
                throw new UnknownAccountException("您不是被邀请用户！！！");
            }
        }catch (NoSuchElementException nee){
            throw new UnknownAccountException(nee.getMessage());
        }

        return new SimpleAuthenticationInfo(telInfo, "", getName());

    }
}