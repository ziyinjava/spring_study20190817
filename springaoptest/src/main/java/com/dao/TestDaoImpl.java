package com.dao;

import org.springframework.stereotype.Repository;

/**
 * @author ziyin
 @create 2019-06-2019/6/18-15:39
 */
@Repository("dao")
public class TestDaoImpl implements TestDao {
    @Override
    public void save() {
        System.out.println("save...run...");
    }
}
