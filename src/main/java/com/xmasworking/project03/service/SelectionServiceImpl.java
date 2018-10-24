package com.xmasworking.project03.service;

import com.xmasworking.project03.entity.DepartmentInfo;
import com.xmasworking.project03.entity.Selection;
import com.xmasworking.project03.model.SelectionModel;
import com.xmasworking.project03.repository.DepartmentInfoRepository;
import com.xmasworking.project03.repository.SelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/24 - 下午3:28
 * Created by IntelliJ IDEA.
 */
@Service
public class SelectionServiceImpl implements SelectionService {

    @Autowired
    private DepartmentInfoRepository departmentInfoRepository;
    @Autowired
    private SelectionRepository selectionRepository;

    @Override
    public List<SelectionModel> findAlLSelectionByAllDept(){
        List<SelectionModel> selectionModels = new ArrayList<>();
        SelectionModel selection;
        for(DepartmentInfo departmentInfo:departmentInfoRepository.findAll()){
            selection = new SelectionModel();
            selection.setId(departmentInfo.getId());
            selection.setName(departmentInfo.getName());
            selection.setRevision(departmentInfo.getRevision());
            selection.setSelectionList(findAllByDept(departmentInfo.getId()));
            selectionModels.add(selection);
        }
        return selectionModels;
    }

    @Override
    public List<Selection> findAllByDept(Long deptId){
        Selection selection = new Selection();
        selection.setDeptid(deptId);
        return selectionRepository.findAll(Example.of(selection));
    }
}
