package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * 不管是jdk的动态代理还是CGLIB的动态代理,在事务方法里,调用另一个事务方法, 都会事务失效, this代表的都是当前真实对象
 * 不是代理对象, 都需要用AopContext获取代理对象,去调用
 */
@Service("accountService")
//@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)//只读型事务的配置
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountDao accountDao;

    @Override
    @Transactional
    public void saveAccount1() {
        accountDao.saveAccount1(new Account("熊大",1000.0f));
        try {
//            saveAccount2();
            ((IAccountService) AopContext.currentProxy()).saveAccount2();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAccount2() {
        accountDao.saveAccount2(new Account("熊二",2000.0f));
        throw new  RuntimeException("saveAccount2...");
    }
}
