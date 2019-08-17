package com.test;

import com.config.AopConfig;
import com.dao.TestDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ziyin
 @create 2019-06-2019/6/18-15:46
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
        TestDaoImpl dao = (TestDaoImpl) ac.getBean("dao");
        dao.save();
        ac.close();
    }
}
