/**
 * @(#)User.java, 2020-07-29.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package collection;

import java.util.Objects;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class User {
    private String name;
    private Integer year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(year, user.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }
}