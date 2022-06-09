package com.haohao.webflux.mapper;

import com.haohao.webflux.domain.SysUser;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author haohao
 */
@Repository
public interface SysUserRepository extends ReactiveSortingRepository<SysUser, Long> {

    /**
     * 名字模糊查询
     *
     * @param name 名称
     * @return Mono
     */
    Mono<SysUser> findByNameContaining(String name);

}




