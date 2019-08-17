package com.itheima.cglib;

import com.itheima.service.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ziyin
 @create 2019-06-2019/6/22-7:38
 */
public class CglibProxyTesst {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                System.out.println("前置代理");
                Object result = methodProxy.invokeSuper(userService, objects);
                System.out.println("后置代理");
                return result;
            }
        });
        UserServiceImpl proxyImpl = (UserServiceImpl) enhancer.create();
    }
}

