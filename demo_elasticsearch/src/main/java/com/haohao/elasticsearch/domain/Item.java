package com.haohao.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;


/**
 * @author haohao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "item", createIndex = false)
public class Item implements Serializable {

    @Id
    private Long id;
    /**
     * title使用ik进行分词
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    /**
     * brand 不被分词
     */
    @Field(type = FieldType.Keyword)
    private String brand;
    @Field(type = FieldType.Double)
    private Double price;
    /**
     * brand 不被分词，且不创建索引
     */
    @Field(index = false, type = FieldType.Keyword)
    private String images;
}
