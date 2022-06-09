package com.haohao.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author haohao
 * @date 2022年06月07日 11:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testId;

    @Column(name = "test_name", unique = true, nullable = false, length = 64)
    private String testName;
}
