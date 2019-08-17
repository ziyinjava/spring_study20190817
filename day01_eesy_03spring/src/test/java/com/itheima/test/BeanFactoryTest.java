package com.itheima.test;

import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author ziyin
 @create 2019-06-2019/6/21-0:00
 */
public class BeanFactoryTest {

    @Test
    public void createBeanTest(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AccountServiceImpl accountService = factory.createBean(AccountServiceImpl.class);
        System.out.println(accountService);
    }

    @Test
    public void BeanStroreTest(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
       factory.registerSingleton("dao",new AccountServiceImpl());
        System.out.println(factory.getBean("dao"));
    }

    /**
     *  自动完成依赖的检测和注入
     */
    @Test
    public void dependencyTest() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AccountServiceImpl accountService = (AccountServiceImpl) factory.createBean(AccountServiceImpl.class, AbstractBeanDefinition.AUTOWIRE_BY_TYPE,true);
        System.out.println(accountService);
    }


    /**
     * 加载xml文件
     * 解析xml文件创建BeanDefinition类
     * Factory注册Bean
     */
    @Test
    public void getBeanTest() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");
        AccountServiceImpl accountService = factory.getBean(AccountServiceImpl.class);
        Assert.assertNotNull(accountService);
    }
}
