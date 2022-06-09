package com.haohao.jpa.repository;

import com.haohao.jpa.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author haohao
 * @date 2022年06月07日 12:01
 */
public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
