
package com.itheima.annotation;

import java.lang.annotation.*;


@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {

    /**
     * 业务的名称
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:账户实体的唯一标识为"id"
     */
    String key() default "id";


}
