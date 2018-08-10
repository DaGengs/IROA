package cn.iruier.web.shiro;

import cn.iruier.entity.Role;
import cn.iruier.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Realm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = (SimpleAuthorizationInfo) session.getAttribute("userroles");
            if (simpleAuthorizationInfo == null) {
                simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            }
            List<Role> roles = user.getRoles();
            for (int i = 0; i < roles.size(); i++) {
                simpleAuthorizationInfo.addRole(roles.get(i).getRole_id() + "");
            }
            session.setAttribute("userroles", simpleAuthorizationInfo);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (token.getUsername() != null && token.getUsername().length() > 0) {
            return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
        } else {
            return null;
        }
    }
}
