package com.malaria.ssm.module.download.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 郑晓辉 on 2016/10/16.
 */
@Controller
@RequestMapping("/district")
public class DistinctController {
//    @Resource
//    private DistrictService districtService;
//
//    @RequestMapping("/getProvinces.do")
//    public
//    @ResponseBody
//    Map<String, Object> getProvince() throws Exception {
//        List<FourLevelLinkage> proList = districtService.getProvinces();
//        Map<String, Object> modelMap = new HashMap<>();
//        modelMap.put("data", proList);
//        return modelMap;
//    }
//
//    @RequestMapping("/getCities.do")
//    public
//    @ResponseBody
//    Map<String, Object> getCities(@RequestParam("provinceId") int provinceId) throws Exception {
//        Map<String, Object> modelMap = new HashMap<>();
//        if (provinceId != 0) {
//            List<FourLevelLinkage> cityList = districtService.getCities(provinceId);
//            modelMap.put("data", cityList);
//            return modelMap;
//        }
//        modelMap.put("data", null);
//        return modelMap;
//    }
//
//    @RequestMapping("/getCounties.do")
//    public
//    @ResponseBody
//    Map<String, Object> getCounties(@RequestParam("cityId") int cityId) throws Exception {
//        Map<String, Object> modelMap = new HashMap<>();
//        if (cityId != 0) {
//            List<FourLevelLinkage> countyList = districtService.getCounties(cityId);
//            modelMap.put("data", countyList);
//            return modelMap;
//        }
//        modelMap.put("data", null);
//        return modelMap;
//    }
//
//    @RequestMapping("/getVillages.do")
//    public
//    @ResponseBody
//    Map<String, Object> getVillages(@RequestParam("countyId") int countyId) throws Exception {
//        Map<String, Object> modelMap = new HashMap<>();
//        if (countyId != 0) {
//            List<FourLevelLinkage> villageList = districtService.getVillages(countyId);
//            modelMap.put("data", villageList);
//            return modelMap;
//        }
//        modelMap.put("data", null);
//        return modelMap;
//    }
}
