package com.demo.common.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author haohao
 * @date 2022年06月20日 15:11
 */
public class TestUnmodifiable {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<User> users = new ArrayList<>();
        users.add(new User("zhangsan", 10));
        users.add(new User("lisi", 1));
        users.add(new User("wangwu", 9));

        List<User> users1 = Collections.unmodifiableList(users);
        List<Integer> integers = Collections.unmodifiableList(list);

        integers.add(3);


    }
}
