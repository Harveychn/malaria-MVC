package com.malaria.ssm.module.whole.mapper;

import com.malaria.ssm.module.whole.pojo.DiseaseExample;
import com.malaria.ssm.module.whole.pojo.Disease;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiseaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int countByExample(DiseaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int deleteByExample(DiseaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer diseaseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int insert(Disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int insertSelective(Disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    List<Disease> selectByExample(DiseaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    Disease selectByPrimaryKey(Integer diseaseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Disease record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table disease
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Disease record);
}