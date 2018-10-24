package com.xmasworking.project03.model;

import com.xmasworking.project03.entity.DepartmentInfo;
import com.xmasworking.project03.entity.Selection;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/24 - 下午3:26
 * Created by IntelliJ IDEA.
 */

@Data
public class SelectionModel extends DepartmentInfo {
    List<Selection> selectionList;
}
