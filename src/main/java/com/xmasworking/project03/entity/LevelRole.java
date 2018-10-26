package com.xmasworking.project03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * @author XmasPiano
 * Created by IntelliJ IDEA.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name="LevelRole")
public class LevelRole extends BaseIdEntity implements Serializable,Cloneable{
//    /** 主键 */
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id ;
    /** 角色名称 */
    private String name ;
    /** 角色级别 */
    private String level ;
    /** 倍率 */
    private Long multiple ;
    /** 乐观锁 */
    private Long revision ;

}