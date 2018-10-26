package com.xmasworking.project03.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/25 - 上午11:29
 * Created by IntelliJ IDEA.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class BaseIdEntity {
    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
}
