package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ziyin
 @create 2019-06-2019/6/23-13:05
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;// 目标对象

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        System.out.println("开始事务.....");
        obj = method.invoke(target, args);// 调用目标对象的方法
        System.out.println("提交事务");
        return obj;
    }

    public static void main(String[] args) {
        Test test = (Test) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(), new Class[]{Test.class},
                new MyInvocationHandler(new TestImpl()));
        test.test1();
        //test.test2();
    }
}
