package com.haohao.elasticsearch.repository;

import com.haohao.elasticsearch.domain.Goods;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author haohao
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, String> {

    /**
     * 搜索
     *
     * @param name
     * @return
     */
    @Highlight(fields = {@HighlightField(name = "name"), @HighlightField(name = "price")})
    @Query("{\"match\":{\"name\":\"?0\"}}")
    List<Goods> search(String name);
}
