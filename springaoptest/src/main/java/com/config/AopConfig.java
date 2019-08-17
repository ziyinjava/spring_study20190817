package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ziyin
 @create 2019-06-2019/6/18-15:34
 */

@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {


}
