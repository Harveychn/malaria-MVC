package com.malaria.ssm.module.whole.pojo;

public class MedicalUnit {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical_unit.medicalUnitID
     *
     * @mbggenerated
     */
    private Integer medicalunitid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical_unit.unitName
     *
     * @mbggenerated
     */
    private String unitname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical_unit.medicalUnitID
     *
     * @return the value of medical_unit.medicalUnitID
     *
     * @mbggenerated
     */
    public Integer getMedicalunitid() {
        return medicalunitid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical_unit.medicalUnitID
     *
     * @param medicalunitid the value for medical_unit.medicalUnitID
     *
     * @mbggenerated
     */
    public void setMedicalunitid(Integer medicalunitid) {
        this.medicalunitid = medicalunitid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical_unit.unitName
     *
     * @return the value of medical_unit.unitName
     *
     * @mbggenerated
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical_unit.unitName
     *
     * @param unitname the value for medical_unit.unitName
     *
     * @mbggenerated
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }
}