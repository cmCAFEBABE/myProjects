/**
 * @(#)validationPojo.java, 2020-11-30.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@Data
public class Person {


    // 错误消息message是可以自定义的
    @NotNull(message = "名字不能为null")
    public String name;
    @Positive
    public Integer age;

    @NotNull
    @NotEmpty
    private List<@Email String> emails;
    @Future
    private Date start;

}