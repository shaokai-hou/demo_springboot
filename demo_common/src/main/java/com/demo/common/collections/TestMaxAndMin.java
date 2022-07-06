package com.demo.common.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author haohao
 * @date 2022年06月20日 14:39
 */
public class TestMaxAndMin {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<User> users = new ArrayList<>();
        users.add(new User("zhangsan", 10));
        users.add(new User("lisi", 1));
        users.add(new User("wangwu", 9));

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println(max);
        System.out.println(min);


        User max2 = Collections.max(users, Comparator.comparing(User::getAge));
        User min2 = Collections.min(users, Comparator.comparing(User::getAge));
        System.out.println(max2);
        System.out.println(min2);
    }
}
