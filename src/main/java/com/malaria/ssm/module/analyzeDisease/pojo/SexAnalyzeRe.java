package com.malaria.ssm.module.analyzeDisease.pojo;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
public class SexAnalyzeRe {
    private int year;
    private String sex;
    private String disease;
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

    public int getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(int patientNum) {
        this.patientNum = patientNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
