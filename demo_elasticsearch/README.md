1、操作es使用 ElasticsearchRepository<Entity,ID>
restHighLevelClient

2、新建Goods

```java

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
```

3、新建GoodsRepository

```java
public interface GoodsRepository extends ElasticsearchRepository<Goods, String> {

    @Highlight(fields = {@HighlightField(name = "name"), @HighlightField(name = "price")})
    @Query("{\"match\":{\"name\":\"?0\"}}")
    List<Goods> search(String name);
}
```
