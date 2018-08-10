package cn.iruier.service;

import cn.iruier.entity.User;

public interface UserService {
    public User login(String no, String password);
}
