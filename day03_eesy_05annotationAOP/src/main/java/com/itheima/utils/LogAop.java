
package com.itheima.utils;

import com.itheima.annotation.BussinessLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAop {

    @Pointcut(value = "@annotation(com.itheima.annotation.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            //获取拦截的方法名
            Signature sig = point.getSignature();
            MethodSignature msig = null;
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) sig;
            Object target = point.getTarget();
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            String methodName = currentMethod.getName();


            //获取拦截方法的参数
            String className = point.getTarget().getClass().getName();
            Object[] params = point.getArgs();

            //获取操作名称
            BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
            String bussinessName = annotation.value();
            String key = annotation.key();

            System.out.println(methodName + "--" + className + "---" + params + "---" + bussinessName + "--" + key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}