package com.xmasworking.project03.repository;

import com.xmasworking.project03.entity.SelectedDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/24 - 上午11:20
 * Created by IntelliJ IDEA.
 */
public interface SelectedDetailRepository
        extends JpaRepository<SelectedDetail, Long> {

    /**
     * sum合计部门得分，并按照月份分类
     * @return
     */
    @Query(nativeQuery = true, value = " select b.name,sum(a.score) as score,a.ym " +
            " from SelectedDetail a left join DepartmentInfo b on a.deptid=b.id WHERE a.ym=?1 " +
            " group by b.name,a.ym order by b.id,a.ym ")
    List<Map> getDeptSelectionScoreGroupYM(String ym);

    /**
     * sum合计部门得分
     * @return
     */
    @Query(nativeQuery = true, value = "select b.name,sum(a.score) as score " +
            "from SelectedDetail a left join DepartmentInfo b on a.deptid=b.id " +
            "group by b.name order by b.name")
    List<SelectedDetail> getDeptSelectionTotleScore();
}
