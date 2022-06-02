package com.haohao.webflux.service;

import cn.hutool.core.convert.Convert;
import com.haohao.webflux.domain.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author haohao
 * @date 2022年05月30日 15:40
 */
@Service
@RequiredArgsConstructor
public class SysUserService {

    final R2dbcEntityTemplate r2dbcEntityTemplate;

    public Flux<SysUser> getPage(Integer page, Integer size) {
        Query query = Query.empty().offset(Convert.toLong((page - 1) * size)).limit(size);
        return r2dbcEntityTemplate.select(query, SysUser.class);
    }

    public Flux<SysUser> getList(SysUser sysUser) {
        CriteriaDefinition criteria = Criteria.where("id").is(1L)
                .and(Criteria.where("name").is("张三"));
        Query query = Query.query(criteria);
        return r2dbcEntityTemplate.select(query, SysUser.class);
    }

    public Mono<SysUser> save(SysUser sysUser) {
        return r2dbcEntityTemplate.insert(sysUser);
    }

}
