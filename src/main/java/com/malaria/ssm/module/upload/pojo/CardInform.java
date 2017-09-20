package com.malaria.ssm.module.upload.pojo;

import java.util.Date;

/**
 * Created by 郑晓辉 on 2017/1/22.
 */
public class CardInform {
    private int year;
    private int cardID;
    private String cardNum;
    private char cardStatus;
    private String patientName;
    //不需要保存的数据字段
//    private String patientParentName;
//    private String ID;
    private char sex;
    private Date birthday;
    private String age;
    private String workUnit;
    private String tel;
    private String belongsLevel;
    private int addressNationID;
    private String address;
    private String career;
    private String caseCategory1Name;
    private String caseCategory2Name;
    private Date illDate;
    private Date confirmDate;
    private Date deathDate;
    private String diseaseName;
    private String diseasePreRevised;
    private String fillCardDoc;
    private Date fillCardDate;
    private String reportUnitAreaCode;
    private String reportUnit;
    private String unitType;
    private Date reportInputDate;
    private String inputUser;
    private String inputUserUnit;
    private String countyJudgeDate;
    private String localJudgeDate;
    private String provinceJudgeDate;
    private char judgeStatus;
    private Date revisedReportDate;
    private Date revisedFinalJudgeDate;
    private Date deathFinalJudgeDate;
    private String revisedUser;
    private String revisedUserUnit;
    private Date delDate;
    private String delUser;
    private String delUserUnit;
    private String delReason;
    private String notes;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public char getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(char cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

//    public String getPatientParentName() {
//        return patientParentName;
//    }
//
//    public void setPatientParentName(String patientParentName) {
//        this.patientParentName = patientParentName;
//    }
//
//    public String getID() {
//        return ID;
//    }
//
//    public void setID(String ID) {
//        this.ID = ID;
//    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBelongsLevel() {
        return belongsLevel;
    }

    public void setBelongsLevel(String belongsLevel) {
        this.belongsLevel = belongsLevel;
    }

    public int getAddressNationID() {
        return addressNationID;
    }

    public void setAddressNationID(int addressNationID) {
        this.addressNationID = addressNationID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCaseCategory1Name() {
        return caseCategory1Name;
    }

    public void setCaseCategory1Name(String caseCategory1Name) {
        this.caseCategory1Name = caseCategory1Name;
    }

    public String getCaseCategory2Name() {
        return caseCategory2Name;
    }

    public void setCaseCategory2Name(String caseCategory2Name) {
        this.caseCategory2Name = caseCategory2Name;
    }

    public Date getIllDate() {
        return illDate;
    }

    public void setIllDate(Date illDate) {
        this.illDate = illDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseasePreRevised() {
        return diseasePreRevised;
    }

    public void setDiseasePreRevised(String diseasePreRevised) {
        this.diseasePreRevised = diseasePreRevised;
    }

    public String getFillCardDoc() {
        return fillCardDoc;
    }

    public void setFillCardDoc(String fillCardDoc) {
        this.fillCardDoc = fillCardDoc;
    }

    public Date getFillCardDate() {
        return fillCardDate;
    }

    public void setFillCardDate(Date fillCardDate) {
        this.fillCardDate = fillCardDate;
    }

    public String getReportUnitAreaCode() {
        return reportUnitAreaCode;
    }

    public void setReportUnitAreaCode(String reportUnitAreaCode) {
        this.reportUnitAreaCode = reportUnitAreaCode;
    }

    public String getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Date getReportInputDate() {
        return reportInputDate;
    }

    public void setReportInputDate(Date reportInputDate) {
        this.reportInputDate = reportInputDate;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public String getInputUserUnit() {
        return inputUserUnit;
    }

    public void setInputUserUnit(String inputUserUnit) {
        this.inputUserUnit = inputUserUnit;
    }

    public String getCountyJudgeDate() {
        return countyJudgeDate;
    }

    public void setCountyJudgeDate(String countyJudgeDate) {
        this.countyJudgeDate = countyJudgeDate;
    }

    public String getLocalJudgeDate() {
        return localJudgeDate;
    }

    public void setLocalJudgeDate(String localJudgeDate) {
        this.localJudgeDate = localJudgeDate;
    }

    public String getProvinceJudgeDate() {
        return provinceJudgeDate;
    }

    public void setProvinceJudgeDate(String provinceJudgeDate) {
        this.provinceJudgeDate = provinceJudgeDate;
    }

    public char getJudgeStatus() {
        return judgeStatus;
    }

    public void setJudgeStatus(char judgeStatus) {
        this.judgeStatus = judgeStatus;
    }

    public Date getRevisedReportDate() {
        return revisedReportDate;
    }

    public void setRevisedReportDate(Date revisedReportDate) {
        this.revisedReportDate = revisedReportDate;
    }

    public Date getRevisedFinalJudgeDate() {
        return revisedFinalJudgeDate;
    }

    public void setRevisedFinalJudgeDate(Date revisedFinalJudgeDate) {
        this.revisedFinalJudgeDate = revisedFinalJudgeDate;
    }

    public Date getDeathFinalJudgeDate() {
        return deathFinalJudgeDate;
    }

    public void setDeathFinalJudgeDate(Date deathFinalJudgeDate) {
        this.deathFinalJudgeDate = deathFinalJudgeDate;
    }

    public String getRevisedUser() {
        return revisedUser;
    }

    public void setRevisedUser(String revisedUser) {
        this.revisedUser = revisedUser;
    }

    public String getRevisedUserUnit() {
        return revisedUserUnit;
    }

    public void setRevisedUserUnit(String revisedUserUnit) {
        this.revisedUserUnit = revisedUserUnit;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public String getDelUser() {
        return delUser;
    }

    public void setDelUser(String delUser) {
        this.delUser = delUser;
    }

    public String getDelUserUnit() {
        return delUserUnit;
    }

    public void setDelUserUnit(String delUserUnit) {
        this.delUserUnit = delUserUnit;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

