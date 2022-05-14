package com.haohao.elasticsearch.jsoup;

import cn.hutool.core.util.StrUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析京东搜索
 *
 * @author haohao
 */
public class DemoJd {

    public static List<Map<String, Object>> parseJdHtml(String keyword) throws Exception {
        List<Map<String, Object>> result = new ArrayList<>();
        String url = "https://search.jd.com/Search?keyword=" + keyword + "&psort=1";
        Document document = Jsoup.parse(new URL(url), 30000);

        Element goodsList = document.getElementById("J_goodsList");
        assert goodsList != null;
        Elements lis = goodsList.getElementsByTag("li");

        for (Element li : lis) {
            String image = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();
            String name = li.getElementsByClass("p-name").eq(0).text();
            if (StrUtil.isAllNotBlank(image, price, name)) {
                Map<String, Object> good = new HashMap<>(3);
                good.put("image", image);
                good.put("price", price.replaceAll("￥", ""));
                good.put("name", name);
                result.add(good);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        DemoJd.parseJdHtml("sk2").forEach(System.out::println);
    }
}
