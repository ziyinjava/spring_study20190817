package com.itheima.proxy;

import com.itheima.service.UserService;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author ziyin
 @create 2019-06-2019/6/22-7:15
 */
public class JavaProxyTest {
    public static void main(String[] args) throws IOException {
        int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass("proxy0", new Class[]{UserService.class}, accessFlags);
        Path path = new File(System.getProperty("user.dir") + "/target/proxy0.class").toPath();
        Files.write(path,proxyClassFile);

        //classLoader.define(proxyClassFile); 获取的Class对象
    }
}
