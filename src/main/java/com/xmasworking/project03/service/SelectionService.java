package com.xmasworking.project03.service;

import com.xmasworking.project03.entity.Selection;
import com.xmasworking.project03.model.SelectionModel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/24 - 下午3:28
 * Created by IntelliJ IDEA.
 */
public interface SelectionService {
    List<SelectionModel> findAlLSelectionByAllDept();

    List<Selection> findAllByDept(Long deptId);
}
