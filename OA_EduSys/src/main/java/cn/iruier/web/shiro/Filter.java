package cn.iruier.web.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Filter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappers) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getRequestURI().contains(".do")) {
            return true;
        }

        Subject subject = getSubject(servletRequest, servletResponse);
        String[] checkRoles = (String[]) mappers;
        for (String checkRole : checkRoles) {
            if (subject.hasRole(checkRole)) {
                return true;
            }
        }
        return false;
    }
}
