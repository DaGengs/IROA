package cn.iruier.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.MD5Utils;
import cn.iruier.common.utils.StringUtils;
import cn.iruier.dao.UserMapper;
import cn.iruier.entity.User;
import cn.iruier.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    public User login(String no, String password) {
        if (StringUtils.empty(no, password)) {
            User user = mapper.queryByNo(no);
            if (Objects.equals(MD5Utils.md5(password), user.getUser_password())) {
                return user;
            }
        }
        return null;
    }
}
