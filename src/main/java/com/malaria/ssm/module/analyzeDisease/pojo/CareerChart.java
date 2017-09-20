package com.malaria.ssm.module.analyzeDisease.pojo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/12/5.
 */
public class CareerChart {
    private String disease;
    private List<String> yearList;
    private List<List> careerList;
    private List<List> valuesList;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<List> getCareerList() {
        return careerList;
    }

    public void setCareerList(List<List> careerList) {
        this.careerList = careerList;
    }

    public List<List> getValuesList() {
        return valuesList;
    }

    public void setValuesList(List<List> valuesList) {
        this.valuesList = valuesList;
    }
}
