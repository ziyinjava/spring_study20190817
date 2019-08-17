package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    void saveAccount1(Account account);

    void saveAccount2(Account account);
}
