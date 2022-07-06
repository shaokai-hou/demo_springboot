package com.demo.common.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找
 *
 * @author haohao
 * @date 2022年06月20日 15:00
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(13);

        Collections.sort(list);
        int i = Collections.binarySearch(list, 2);
        System.out.println(i);
    }
}
