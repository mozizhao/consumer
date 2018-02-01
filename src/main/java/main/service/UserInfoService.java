package main.service;

import main.domain.UserInfo;

public interface UserInfoService {
    UserInfo validate(String username, String password);

    UserInfo getUserInfoById(Integer id);
}
