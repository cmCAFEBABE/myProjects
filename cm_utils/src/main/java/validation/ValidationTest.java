/**
 * @(#)validationTest.java, 2020-11-30.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package validation;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Arrays;
import java.util.Set;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class ValidationTest {
    @Test
    public void test(){
        Person person = new Person();
        //person.setName("fsx");
        person.setAge(-1);
        // email校验：虽然是List都可以校验哦
        person.setEmails(Arrays.asList("fsx@gmail.com", "baidu@baidu.com", "aaa.com"));
        //person.setStart(new Date()); //start 需要是一个将来的时间: Sun Jul 21 10:45:03 CST 2019
        //person.setStart(new Date(System.currentTimeMillis() + 10000)); //校验通过

        // 对person进行校验然后拿到结果（显然使用时默认的校验器）   会保留下校验失败的消息
        Set<ConstraintViolation<Person>> result = Validation.buildDefaultValidatorFactory().getValidator().validate(person);
        // 对结果进行遍历输出
        result.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);
    }

}