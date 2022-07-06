package com.demo.common.collections;

import cn.hutool.core.collection.CollectionUtil;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author haohao
 * @date 2022年06月20日 15:15
 */
public class TestMerge {
    public static void main(String[] args) {
        List<User> user1 = new ArrayList<>();
        user1.add(new User("zhangsan", 10));
        user1.add(new User("lisi", 1));
        user1.add(new User("wangwu", 9));

        List<User> user2 = new ArrayList<>();
        user2.add(new User("zhangsan", 10));
        user2.add(new User("lisi", 1));


        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);


        // 并集
        Collection<Integer> union1 = CollectionUtil.union(list1, list2);
        List<Integer> union2 = CollectionUtil.unionAll(list1, list2);
        System.out.println(union1);
        System.out.println(union2);

        Collection<User> users1 = CollectionUtil.union(user1, user2);
        List<User> users2 = CollectionUtil.unionAll(user1, user2);
        System.out.println(users1);
        System.out.println(users2);

        // 交集
        Collection<Integer> intersection = CollectionUtil.intersection(list1, list2);
        Collection<User> intersection1 = CollectionUtil.intersection(users1, users2);
        System.out.println(intersection);
        System.out.println(intersection1);
    }
}
