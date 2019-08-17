package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveAccount1(Account account) {
        save(account);
    }

    @Override
    public void saveAccount2(Account account) {
        save(account);
    }

    public void save(Account account){
        jdbcTemplate.update("insert into account(name, money) VALUE (?,?)",account.getName(),account.getMoney());
    }
}
