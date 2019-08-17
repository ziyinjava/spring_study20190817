package com.itheima.service.impl;

import com.itheima.annotation.BussinessLog;
import com.itheima.bo.User;
import com.itheima.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author ziyin
 @create 2019-06-2019/6/21-15:34
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Override
    @BussinessLog(value = "保存用户",key = "id")
    public void saveUser(User user) {
        System.out.println("save.. user..." + user);
    }

}
