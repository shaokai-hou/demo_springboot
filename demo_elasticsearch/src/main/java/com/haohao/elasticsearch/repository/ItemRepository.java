package com.haohao.elasticsearch.repository;

import com.haohao.elasticsearch.domain.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author haohao
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

    /**
     * 方法名必须遵守SpringData的规范
     * 价格区间查询
     *
     * @param price1 price1
     * @param price2 price2
     * @return List
     */
    List<Item> findByPriceBetween(double price1, double price2);
}
