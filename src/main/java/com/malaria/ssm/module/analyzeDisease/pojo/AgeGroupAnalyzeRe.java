package com.malaria.ssm.module.analyzeDisease.pojo;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
public class AgeGroupAnalyzeRe {
    private int year;
    private String disease;
    private String ageGroup;
    private int patientNum;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(int patientNum) {
        this.patientNum = patientNum;
    }
}
