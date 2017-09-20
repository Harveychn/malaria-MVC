package com.malaria.ssm.module.analyzeDisease.service;

import com.malaria.ssm.module.analyzeDisease.pojo.AgeGroupChart;
import com.malaria.ssm.module.analyzeDisease.pojo.CareerChart;
import com.malaria.ssm.module.analyzeDisease.pojo.SexChart;
import com.zxh.ssm.module.analyzeDisease.pojo.*;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
public interface AnalyzeService {
    List<SexChart> analyzeBySex(String dataSource) throws Exception;

    List<CareerChart> analyzeByCareer(String dataSource) throws Exception;

    List<AgeGroupChart> analyzeByAgeGroup(String dataSource) throws Exception;
}
