package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ziyin
 @create 2019-06-2019/6/21-23:33

 1.加载资源xml文件
 2.先创建BeanFactory, 解析xml文件至beanDefinition,并注册到factory中
 3.对BeanFactory进行初始化, 对Bean(Singleton, 非LazyInit, 非抽象的Bean)进行初始化
 */
public class ApplicationTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        context.start();
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        System.out.println(accountService);
    }
}
