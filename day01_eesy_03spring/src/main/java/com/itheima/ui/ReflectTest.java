package com.itheima.ui;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * @author ziyin
 @create 2019-06-2019/6/23-19:32
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Class<?> clazz = Class.forName("com.itheima.dao.impl.AccountDaoImpl");
        AccountDaoImpl accountDao = (AccountDaoImpl) clazz.newInstance();
        Class<?> accountServiceClazz = Class.forName("com.itheima.service.impl.AccountServiceImpl");
        AccountServiceImpl accountService  = (AccountServiceImpl) accountServiceClazz.newInstance();

        accountService.setAccountDao(accountDao);


    }
}
