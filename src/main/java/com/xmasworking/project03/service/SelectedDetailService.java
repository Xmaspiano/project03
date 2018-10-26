package com.xmasworking.project03.service;

import com.xmasworking.project03.entity.SelectedDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/25 - 上午11:20
 * Created by IntelliJ IDEA.
 */
public interface SelectedDetailService {
    List<SelectedDetail> getDeptSelectionTotleScore();

    List<Map> getDeptSelectionTotleScoreByYM(String ym);

    List<SelectedDetail> getAllByYM(String ym);

    List<SelectedDetail> saveByLevelRoleScore(List<SelectedDetail> selectedDetail);

    Boolean hasCommitByTel();
}
