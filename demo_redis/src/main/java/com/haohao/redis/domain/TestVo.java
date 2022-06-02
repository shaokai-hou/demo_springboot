package com.haohao.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author haohao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVo implements Serializable {

    private Long id = 1L;
    private String name = "张三";

}
