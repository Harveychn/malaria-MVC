package com.malaria.ssm.module.whole.mapper;

import com.malaria.ssm.module.whole.pojo.Patient;
import com.malaria.ssm.module.whole.pojo.PatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int countByExample(PatientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int deleteByExample(PatientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer patientid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int insert(Patient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int insertSelective(Patient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    List<Patient> selectByExample(PatientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    Patient selectByPrimaryKey(Integer patientid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Patient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patient
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Patient record);
}