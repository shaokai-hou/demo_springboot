package com.demo.common.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author haohao
 * @date 2022年06月20日 14:54
 */
public class TestSynchronized {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<User> users = new ArrayList<>();
        users.add(new User("zhangsan", 10));
        users.add(new User("lisi", 1));
        users.add(new User("wangwu", 9));

        List<Integer> integers = Collections.synchronizedList(list);
        Collection<Integer> integers1 = Collections.synchronizedCollection(list);
        List<User> users1 = Collections.synchronizedList(users);

        System.out.println(integers);
        System.out.println(integers1);
        System.out.println(users1);
    }
}
