package com.haohao.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author haohao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "goods_list")
public class Goods implements Serializable {

    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String image;
    @Field(type = FieldType.Double)
    private Double price;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;
}
