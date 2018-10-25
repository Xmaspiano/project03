package com.xmasworking.project03.util;

import com.xmasworking.project03.entity.BaseIdEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/25 - 上午11:27
 * Created by IntelliJ IDEA.
 */
@Component
public class EntityListToMap<T extends BaseIdEntity> {

    public Map<Long,T> toMap(List<T> li){
        Map<Long,T> map = new HashMap<>();
        for(T t:li){
            map.put(t.getId(),t);
        }
        return map;
    }
}
