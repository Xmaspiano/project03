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
public class SelectedDetail extends BaseIdEntity implements Serializable,Cloneable{
//    /** 主键 */
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id ;
    /** 手机信息ID */
    private Long telid ;
    /** 选项信息ID */
    private Long selectid ;
    /** 部门ID */
    private Long deptid ;
    /** 得分 */
    private Long score ;
    /** 年月 */
    private String ym ;
    /** 乐观锁 */
    private Long revision ;
    /** 创建人;存储session对象名称：手机号 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;

}