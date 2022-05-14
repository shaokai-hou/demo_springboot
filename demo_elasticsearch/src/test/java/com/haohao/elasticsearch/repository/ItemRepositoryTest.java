package com.haohao.elasticsearch.repository;

import com.haohao.elasticsearch.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ItemRepositoryTest {

    @Resource
    private ItemRepository itemRepository;

    @Test
    void findByPriceBetween() {
    }

    @Test
    void save(){
        Item item = new Item(1L, "小米手机7", "小米", 3499.00, "https://xxx/xxx.jpg");
        itemRepository.save(item);
    }

    @Test
    void batchSave(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(6L, "小米手机71", "小米", 3299.00, "http://xxx/1.jpg"));
        list.add(new Item(7L, "坚果手机R11", "锤子", 3699.00, "http://xxx/1.jpg"));
        list.add(new Item(8L, "华为META101", "华为", 4499.00, "http://xxx/1.jpg"));
        list.add(new Item(9L, "小米Mix2S1", "小米", 4299.00, "http://xxx/1.jpg"));
        list.add(new Item(10L, "荣耀V101", "华为", 2799.00, "http://xxx/1.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }
}