package com.xmasworking.project03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
@Table(name="SelectedDetail")
public class SelectedDetail implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    /** 手机信息ID */
    private Integer telid ;
    /** 选项信息ID */
    private Integer selectid ;
    /** 得分 */
    private Integer score ;
    /** 乐观锁 */
    private Integer revision ;
    /** 创建人;存储session对象名称：手机号 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;

}