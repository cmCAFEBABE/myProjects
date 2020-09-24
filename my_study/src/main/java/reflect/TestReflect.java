/**
 * @(#)TestReflect.java, 2020-09-23.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 * https://blog.csdn.net/u014750606/article/details/79977114
 */
public class TestReflect {

    /**
     * 获取注解属性值
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        //获取Bar实例
        Bar bar = new Bar();
        //获取Bar的val字段
        Field field = Bar.class.getDeclaredField("val");
        //获取val字段上的Foo注解实例
        Foo foo = field.getAnnotation(Foo.class);
        //获取Foo注解实例的 value 属性值
        String value = foo.value();
        //打印该值
        System.out.println(value); // fff
    }

    /**
     * 修改注解的属性值
     */
    @Test
    public void test2() throws Exception{
        //获取Bar实例
        Bar bar = new Bar();
        //获取Bar的val字段
        Field field = Bar.class.getDeclaredField("val");
        //获取val字段上的Foo注解实例
        Foo foo = field.getAnnotation(Foo.class);
        //获取 foo 这个代理实例所持有的 InvocationHandler
        InvocationHandler h = Proxy.getInvocationHandler(foo);
        // 获取 AnnotationInvocationHandler 的 memberValues 字段
        Field hField = h.getClass().getDeclaredField("memberValues");
        // 因为这个字段事 private final 修饰，所以要打开权限
        hField.setAccessible(true);
        // 获取 memberValues
        Map memberValues = (Map) hField.get(h);
        // 修改 value 属性值
        memberValues.put("value", "min");
        // 获取 foo 的 value 属性值
        String value = foo.value();
        System.out.println(value); // ddd

    }
}