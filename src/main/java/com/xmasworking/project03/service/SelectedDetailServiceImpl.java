package com.xmasworking.project03.service;

import com.xmasworking.project03.entity.SelectedDetail;
import com.xmasworking.project03.repository.DepartmentInfoRepository;
import com.xmasworking.project03.repository.SelectedDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/25 - 上午10:17
 * Created by IntelliJ IDEA.
 */
@Service
public class SelectedDetailServiceImpl implements SelectedDetailService {

    @Autowired
    private DepartmentInfoRepository departmentInfoRepository;

    @Autowired
    private SelectedDetailRepository selectedDetailRepository;

    @Override
    public List<SelectedDetail> getDeptSelectionTotleScore(){
        return selectedDetailRepository.getDeptSelectionTotleScore();
    }

    @Override
    public List<Map> getDeptSelectionTotleScoreByYM(String ym){
        List<Map> selectedDetails = selectedDetailRepository.getDeptSelectionScoreGroupYM(ym);
        return selectedDetails;
    }

    @Override
    public List<SelectedDetail> getAllByYM(String ym){
        if ("".equals(ym)){
            return new ArrayList<>();
        }
        SelectedDetail selectedDetail = new SelectedDetail();
        selectedDetail.setYm(ym);
        return selectedDetailRepository.findAll(Example.of(selectedDetail));
    }

}
