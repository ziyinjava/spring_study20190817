package com.itheima.ui;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ziyin
 @create 2019-06-2019/6/23-19:04
 */
public class Test {
    public static void main(String[] args) {
        List list = Arrays.asList(1, 2, 3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }}
