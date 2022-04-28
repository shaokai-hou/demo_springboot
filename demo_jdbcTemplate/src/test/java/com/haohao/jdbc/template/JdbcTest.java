package com.haohao.jdbc.template;

import com.haohao.jdbc.template.domain.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class JdbcTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void update() {
        String sql = "update sys_user set name = ? where id = ?";
        jdbcTemplate.update(sql, "jdbc", 5);
    }

    @Test
    void insert() {
        String sql = "insert into sys_user(id,name) values (?,?);";
        jdbcTemplate.update(sql, null, "哈哈哈哈");
    }

    @Test
    void delete() {
        String sql = "delete from sys_user where id = ?";
        jdbcTemplate.update(sql, 6);
    }

    @Test
    void selectOne() {
        String sql = "select id,name from sys_user where id = ?";
        Map<String, Object> query = jdbcTemplate.queryForMap(sql, 3);
        System.out.println(query);
    }

    @Test
    void selectList() {
        String sql = "select id,name from sys_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    void selectListForBean() {
        String sql = "select id,name from sys_user";
        List<SysUserEntity> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SysUserEntity.class));
        userList.forEach(System.out::println);
    }

    @Test
    void selectCount() {
        String sql = "select count(*) from sys_user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
}
