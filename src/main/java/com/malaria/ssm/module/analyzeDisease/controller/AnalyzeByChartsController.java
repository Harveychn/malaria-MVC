package com.malaria.ssm.module.analyzeDisease.controller;

import com.malaria.ssm.module.analyzeDisease.pojo.AgeGroupChart;
import com.malaria.ssm.module.analyzeDisease.pojo.CareerChart;
import com.malaria.ssm.module.analyzeDisease.pojo.SexChart;
import com.zxh.ssm.module.analyzeDisease.pojo.*;
import com.malaria.ssm.module.analyzeDisease.service.AnalyzeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 根据疾病进行分类
 * 展示疾病人群的性别、职业、年龄段的关系
 * Created by 郑晓辉 on 2016/10/3.
 */
@Controller
@RequestMapping("/AnalyzeByCharts")
public class AnalyzeByChartsController {
    @Resource
    private AnalyzeService analyzeService;

    @RequestMapping("analyzeView")
    public String analyzeView() throws Exception {
        return "../../analyzeSexChart";
    }

    /*性别比例分析*/
    @RequestMapping(value = "/sexChart", method = RequestMethod.POST)
    public
    @ResponseBody
    List<SexChart> sexChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        return analyzeService.analyzeBySex(dataSource);
    }

    /*职业比例分析*/
    @RequestMapping(value = "/careerChart", method = RequestMethod.POST)
    public
    @ResponseBody
    List<CareerChart> careerChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        return analyzeService.analyzeByCareer(dataSource);
    }

    @RequestMapping(value = "/ageGroupChart", method = RequestMethod.POST)
    public
    @ResponseBody
    List<AgeGroupChart> ageGroupChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        return analyzeService.analyzeByAgeGroup(dataSource);
    }
}
