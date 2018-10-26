package com.xmasworking.project03.service;

import com.xmasworking.project03.entity.LevelRole;
import com.xmasworking.project03.entity.SelectedDetail;
import com.xmasworking.project03.entity.TelInfo;
import com.xmasworking.project03.repository.DepartmentInfoRepository;
import com.xmasworking.project03.repository.LevelRoleRepository;
import com.xmasworking.project03.repository.SelectedDetailRepository;
import com.xmasworking.project03.util.Common;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private LevelRoleRepository levelRoleRepository;

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

    @Override
    public List<SelectedDetail> saveByLevelRoleScore(List<SelectedDetail> selectedDetail){
        Subject subject = SecurityUtils.getSubject();
        TelInfo telInfo = (TelInfo) subject.getPrincipal();

        for(SelectedDetail ss:selectedDetail){
            ss.setTelid(telInfo.getId());
            ss.setCreatedBy(telInfo.getTelno());
            ss.setScore(getLevelRoleScore(ss.getScore()));
            ss.setYm(Common.getDateYM());
        }

        return selectedDetailRepository.saveAll(selectedDetail);
    }

    @Override
    public Boolean hasCommitByTel(){
        Subject subject = SecurityUtils.getSubject();
        TelInfo telInfo = (TelInfo) subject.getPrincipal();
        String ym = Common.getDateYM();

        SelectedDetail selectedDetail = new SelectedDetail();
        selectedDetail.setYm(ym);
        selectedDetail.setTelid(telInfo.getId());
        List<SelectedDetail> list = selectedDetailRepository.findAll(Example.of(selectedDetail));
        return list.size()>0;
    }

    /**
     * 计算权重后的分值
     * @param score
     * @return
     */
    private Long getLevelRoleScore(Long score){
        Subject subject = SecurityUtils.getSubject();
        TelInfo telInfo = (TelInfo) subject.getPrincipal();
        Optional<LevelRole> levelRole = levelRoleRepository.findById(telInfo.getLevelid());
        if(levelRole.isPresent()){
            score = score * levelRole.get().getMultiple();
            System.out.println(telInfo.getTelno()+"的权重分值为："+score);
        }
        return score;
    }

}
