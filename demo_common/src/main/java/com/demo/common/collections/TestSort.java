package com.demo.common.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author haohao
 * @date 2022年06月20日 14:26
 */
public class TestSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<User> users = new ArrayList<>();
        users.add(new User("zhangsan", 10));
        users.add(new User("lisi", 1));
        users.add(new User("wangwu", 9));

        // 升序
        Collections.sort(list);
        System.out.println(list);
        // 降序
        Collections.reverse(list);
        System.out.println(list);

        // 自定义排序
        // 降序
        users.sort((o1, o2) -> o2.getAge().compareTo(o1.getAge()));
        System.out.println(users);
        // 升序
        users.sort(Comparator.comparing(User::getAge));
        System.out.println(users);
        // 实体类实现排序接口
        users.sort(new User());
        System.out.println(users);
    }

}
