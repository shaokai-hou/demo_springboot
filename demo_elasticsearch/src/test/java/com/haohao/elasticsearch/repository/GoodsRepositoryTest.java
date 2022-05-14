package com.haohao.elasticsearch.repository;

import cn.hutool.core.bean.BeanUtil;
import com.haohao.elasticsearch.domain.Goods;
import com.haohao.elasticsearch.jsoup.DemoJd;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
class GoodsRepositoryTest {

    @Resource
    private GoodsRepository goodsRepository;
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void saveAll() throws Exception {
        List<Map<String, Object>> mapList = DemoJd.parseJdHtml("小米");
        List<Goods> goodsList = new ArrayList<>();
        mapList.forEach(map -> goodsList.add(BeanUtil.toBean(map, Goods.class)));
        goodsRepository.saveAll(goodsList);
    }

    @Test
    void findById() {
        System.out.println(goodsRepository.findById("3BPkwYABFau1NRP3_R_0"));
    }

    @Test
    void findAll() {
        goodsRepository.findAll().forEach(System.out::println);
    }

    @Test
    void search() {
//        goodsRepository.searchSimilar()
//        elasticsearchRestTemplate.search()
    }

    @Test
    void testSearch() {
        goodsRepository.search("礼盒").forEach(System.err::println);
    }
}