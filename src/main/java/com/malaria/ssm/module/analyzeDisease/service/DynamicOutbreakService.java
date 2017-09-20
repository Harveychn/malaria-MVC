package com.malaria.ssm.module.analyzeDisease.service;

import com.malaria.ssm.module.analyzeDisease.pojo.DynamicOutbreakRe;
import com.malaria.ssm.module.analyzeDisease.pojo.DynamicOutbreakVo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
public interface DynamicOutbreakService {
    List<DynamicOutbreakRe> findAddressList(DynamicOutbreakVo dynamicOutbreakVo) throws Exception;
}
