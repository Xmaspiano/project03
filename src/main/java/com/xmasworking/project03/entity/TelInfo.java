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
@Table(name="TelInfo")
public class TelInfo extends BaseIdEntity implements Serializable,Cloneable{
//    /** 主键 */
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id ;
    /** 电话号码 */
    private String telno ;
    /** 级别角色 */
    private Long levelid ;
    /** 乐观锁 */
    private Long revision ;

}